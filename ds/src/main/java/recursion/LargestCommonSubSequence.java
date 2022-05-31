package recursion;

/*

Note:
substring: continuous
subsequence: discontinuous.

Given two string, print the largest common subsequence between two strings.

s1 = "abcdgh"
s2 = "abedfhr"
common chars are: "a,b,d,h"
O/p: Longest common subsequence: 4

 */
public class LargestCommonSubSequence {

    public static void main(String[] args) {

        String s1 = "abcdgh";
        String s2 = "abedfhr";
        int output = getLongestCommonSubSequence(s1,s2,s1.length()-1,s2.length()-1);
        System.out.println(output);
    }

    private static int getLongestCommonSubSequence(String s1, String s2, int s1Index, int s2Index) {

        if(s1Index < 0 || s2Index < 0){
            return 0;
        }
        if (s1.charAt(s1Index) == s2.charAt(s2Index)) {
            return 1+getLongestCommonSubSequence(s1,s2,s1Index-1,s2Index-1);
        }
        else{
            return Math.max(getLongestCommonSubSequence(s1,s2,s1Index-1,s2Index),
                    getLongestCommonSubSequence(s1,s2,s1Index,s2Index-1));
        }
    }
}
