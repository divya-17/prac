package greedy;

import java.util.Iterator;
import java.util.TreeSet;


/*
https://practice.geeksforgeeks.org/problems/choose-and-swap5932/1

Ex1:
S="ccad"
O/p: "aacd"

Ex2:
S="abba"
O/p: "abba"

Ex3:
S="adcba"
O/p: "abcda"
 */
public class ChangeAndSwap {

    public static void main(String[] args) {

        String s1 ="ccad";
        String s2="abba";
        String s3="adcba";

        changeAndSwap(s1);
        changeAndSwap(s2);
        changeAndSwap(s3);
    }

    private static void changeAndSwap(String str) {

        System.out.println("Original =>"+str);
        String newStr = null;
        TreeSet<Character> charSet = new TreeSet<>();

        for(int i=0; i <str.length(); i++){
            charSet.add(str.charAt(i));
        }

        Iterator<Character> charSetIterator = charSet.iterator();


        for(int i =0; i <str.length(); i++){
            if(charSetIterator.hasNext()){
                Character charToCompare = charSetIterator.next();
                if(str.charAt(i) != charToCompare){
                     newStr =replace(str,str.charAt(i),charToCompare);
                    break;
                }
                else {
                    charSetIterator.remove();
                }
            }
        }
        if(newStr == null){
            newStr = str;
        }
        System.out.println("Ans: "+newStr);
    }

    private static String replace(String str, char charAt, Character charToCompare) {

        String newStr="";
        for(int i =0; i < str.length(); i++){
            if(str.charAt(i) == charAt){
                newStr=newStr+charToCompare;
            }
            else if(str.charAt(i) == charToCompare){
                newStr = newStr+charAt;
            }
            else {
                newStr = newStr+str.charAt(i);
            }
        }
        return newStr;
    }

}
