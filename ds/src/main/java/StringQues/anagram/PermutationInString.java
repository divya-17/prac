package StringQues.anagram;

import scala.Char;

import java.util.Arrays;

/*

Given two strings s1 and s2, return true if s2 contains the permutation of s1.


Ex:

s1 = "ab"
s2 = "eidbaooo"

result: true
s2 contains 1 permutation of s1 s1("ba")

Note: permutation of a string is same as anagrams of the string

 */
public class PermutationInString {

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        Boolean result = permutationInString(s1, s2);
        System.out.println(result);
    }

    private static Boolean permutationInString(String s1, String s2) {

        int[] largerStrArr = new int[26];
        int[] smallerStrArr = new int[26];

        int slidingWindowSize = s1.length();

        for (Character c : s1.toCharArray()) {
            smallerStrArr[c - 'a'] = smallerStrArr[c - 'a'] + 1;
        }

//        System.out.println(" Smaller sub string array");
//        for (int k : smallerStrArr) {
//            System.out.print(k + " , ");
//        }
//        System.out.println();

        for (int i = 0; i <= (s2.length() - slidingWindowSize + 1); i++) {

            if(i+slidingWindowSize < s2.length()-1) {

                for (int j = i; j < (i + slidingWindowSize); j++) {

                    largerStrArr[s2.charAt(j) - 'a'] = largerStrArr[s2.charAt(j) - 'a'] + 1;
                }

//                System.out.println("Larger sub array is ");
//                for(int k : largerStrArr){
//                    System.out.print(k+" , ");
//                }
//                System.out.println();

                if (Arrays.equals(smallerStrArr, largerStrArr)) {
                    return true;
                }
                Arrays.fill(largerStrArr, 0);
            }

        }
        return false;
    }
}
