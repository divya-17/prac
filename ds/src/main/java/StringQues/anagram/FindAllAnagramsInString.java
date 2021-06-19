package StringQues.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Given a long string S and a shorter string P, find all starting indices of anagrams of P in S

Ex:

S = "a b c d e c d b a c b"
P = "c a b"

 */
public class FindAllAnagramsInString {


    public static void main(String[] args) {

        String S = "abcdecdbacb";
        String P = "cab";

//        String S = "cbaebabacd";
//        String P = "abc";

//        String S = "ababababab";
//        String P = "aab";

        List<Integer> indicesList = getAllStrtIndicesOfAnagram(S, P);

        System.out.println(indicesList);

    }

    private static List<Integer> getAllStrtIndicesOfAnagram(String largerStr, String smallerStr) {


        int slidingWindow = smallerStr.length();
        List<Integer> startingIndicesList = new ArrayList<>();

        int[] largerStrByteArr = new int[26];
        int[] smallerStrByteArr = new int[26];


        for(int b: smallerStrByteArr){
            System.out.print(b+" , ");
        }
        System.out.println();

        for(Character c: smallerStr.toCharArray()){
            smallerStrByteArr[c-'a'] =smallerStrByteArr[c-'a'] + 1;
        }

//        for(Byte b: smallerStrByteArr){
//            System.out.print(b+" , ");
//        }
//        System.out.println();

        for(int i = 0; i <= largerStr.length()-slidingWindow; i++){

            System.out.println("Checkin from "+largerStr.charAt(i)+" to "+largerStr.charAt(i+slidingWindow-1));


            for(int j = i; j < (i+slidingWindow);j++){

                largerStrByteArr[largerStr.charAt(j)-'a'] = largerStrByteArr[largerStr.charAt(j)-'a'] + 1;
            }

//            for(Byte b: largerStrByteArr){
//                System.out.print(b+" , ");
//            }
//            System.out.println();


            if (Arrays.equals(largerStrByteArr,smallerStrByteArr)) {
                startingIndicesList.add(i);
            }

            Arrays.fill(largerStrByteArr, (byte) 0);
        }

        return startingIndicesList;
    }
}
