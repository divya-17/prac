package dynamicProgramming.knapsackAndVariations;

/*
Given two strings, find the longest common substring.

 Ex:
 s1 = "ABCDE"
 s2 = "ABFCE"

Substrings are: ["AB","C","E"]
Longest common substring: ["AB"], len = 2
 */
public class LongestCommonSubString {

    public static void main(String[] args) {

        String s1 ="ABCDE";
        String s2 ="ABFCE";

        int res = getLongestCommonSubstr(s1,s2,s1.length()-1,s2.length()-1,0);
        System.out.println(res);
    }

    private static int getLongestCommonSubstr(String s1, String s2, int s1Index, int s2Index, int lcsVal) {

        if(s1Index < 0 || s2Index < 0) return lcsVal;

        if(s1.charAt(s1Index) == s2.charAt(s2Index)){
            lcsVal = getLongestCommonSubstr(s1,s2,s1Index-1,s2Index-1,lcsVal+1);
        }
        return Math.max(lcsVal,Math.max(getLongestCommonSubstr(s1,s2,s1Index-1,s2Index,0),
                        getLongestCommonSubstr(s1,s2,s1Index,s2Index-1,0)));
    }
}
