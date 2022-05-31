package dynamicProgramming.knapsackAndVariations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
DP => Memoization

https://www.youtube.com/watch?v=4Urd0a0BNng&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=19

Substring => Continuous
SubSequence => Not continuous
Ex:
String s1 = "abdf";
String s2 = "acdg";

common characters are: "a","d" so largest common subsequence will be "ad";
output : 2

 */
public class LargestCommonSubSequence {

    static List<Character> allMatches = new ArrayList();


    public static void main(String[] args) {

//        String s1 = "abcdgh";
//        String s2 = "abedfhr";

        String s1 = "afcd";
        String s2 = "acwd";


        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int[] row: dp){
            Arrays.fill(row,-1);
        }

        int totalLength = getLongestCommonSubSequence(s1,s2,s1.length()-1,s2.length()-1,dp);
        System.out.println(totalLength);
        System.out.println(allMatches);
    }

                            private static int getLongestCommonSubSequence(String s1, String s2, int s1Length, int s2Length, int[][] dp) {

        if(s1Length < 0 || s2Length < 0){
            return 0;
        }
        if(dp[s1Length][s2Length] != -1){
            return dp[s1Length][s2Length];
        }
        if(s1.charAt(s1Length) == s2.charAt(s2Length)){
           // System.out.println("Match found=>"+s1.charAt(s1Length));
            System.out.println("Match found for "+s1.charAt(s1Length)+" at s1 index "+s1Length+" and s2 index "+s2Length);
            allMatches.add(s1.charAt(s1Length));
            return dp[s1Length][s2Length] = 1 + getLongestCommonSubSequence(s1,s2,s1Length-1,s2Length-1,dp);
        }
        else {
            return dp[s1Length][s2Length] = Math.max(getLongestCommonSubSequence(s1,s2,s1Length-1,s2Length,dp),
                    getLongestCommonSubSequence(s1, s2,s1Length,s2Length-1,dp));
        }

    }

}
