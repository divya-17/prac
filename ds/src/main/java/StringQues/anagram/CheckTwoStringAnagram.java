package StringQues.anagram;

import java.util.HashMap;
import java.util.Map;

/*

Anagram: An anagram of a string is another string which has same characters
but arranged in different order:

Ex: Anagram words:

(Listen) -> (Silent)
(Triangle) -> (Integral)

Given two words find if the two words are anagram.

 */
public class CheckTwoStringAnagram {


    public static void main(String[] args) {
//
//        String s1 = "silent";
//        String s2 = "listen";

        String s1="triangle";
        String s2="integral";

        if(areAnagram(s1,s2)){
            System.out.println("Words "+s1+" and "+s2+" are anagrams");
        }
        else{
            System.out.println("Words "+s1+" and "+s2+" are not anagrams ");
        }
    }

    private static boolean areAnagram(String s1, String s2) {

        Map<Character,Integer> s1CharacterFreqMap = new HashMap<>();
        Map<Character,Integer> s2CharacterFreqMap = new HashMap<>();

        if(s1.length() == s2.length()){

            for(Character c: s1.toCharArray()){
                if(s1CharacterFreqMap.containsKey(c)){
                    s1CharacterFreqMap.put(c,s1CharacterFreqMap.get(c)+1);
                }
                else {
                    s1CharacterFreqMap.put(c,1);
                }
            }

            for(Character c: s2.toCharArray()){

                if(s2CharacterFreqMap.containsKey(c)){
                    s2CharacterFreqMap.put(c,s2CharacterFreqMap.get(c)+1);
                }
                else {
                    s2CharacterFreqMap.put(c,1);
                }
            }

            if(s1CharacterFreqMap.equals(s2CharacterFreqMap)){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
