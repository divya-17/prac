package dynamicProgramming.knapsackAndVariations;

/*
Given two string, count the length of shortest common super sequence
shortest common super sequence is the minimum length string that contains characters from both the strings.
Ex:
s1 : "AGGTAB"
s2: "GXTXAYB"

O/p: "AGGXTXAYB" -> 9
Explaination: Common subsequence in both string is "GTAB" so this needs to be included only once

https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24

 */
public class ShotestCommonSuperSequence {

    public static void main(String[] args) {

        String s1 ="AGGTAB";
        String s2 = "GXTXAYB";
        int lcsLength = getCountOfLCS(s1,s2,s1.length()-1,s2.length()-1);
        int shortestCommSuperSeq = s1.length()+s2.length()-lcsLength;
        System.out.println(shortestCommSuperSeq);
    }

    private static int getCountOfLCS(String s1, String s2, int s1Len, int s2Len) {

        if(s1Len < 0 || s2Len < 0){
            return 0;
        }
        if(s1.charAt(s1Len) == s2.charAt(s2Len)){
            return 1+getCountOfLCS(s1,s2,s1Len-1,s2Len-1);
        }

        return Math.max(getCountOfLCS(s1,s2,s1Len-1,s2Len),
                getCountOfLCS(s1,s2,s1Len,s2Len-1));

    }
}
