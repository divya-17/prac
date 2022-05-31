package dynamicProgramming.knapsackAndVariations;

/*
https://www.youtube.com/watch?v=wuOOOATz_IA&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=26
Given a string s, find the longest palindromic subsequence of the string
s = "agbcba";
O/p: "abcba" , len = 5

 */
public class LongestPalindromicSubSequence {

    public static void main(String[] args) {

        String s = "agbcbaf";
        int count = getLongestPalindromicSubSeq(s,reverse(s),s.length()-1,s.length()-1);
        System.out.println(count);
    }

    private static int getLongestPalindromicSubSeq(String s1, String s2, int s1Len, int s2Len) {

        if(s1Len < 0|| s2Len < 0){
            return 0;
        }
        if(s1.charAt(s1Len) == s2.charAt(s2Len)){
            return 1+getLongestPalindromicSubSeq(s1,s2,s1Len-1,s2Len-1);
        }
        else {
            return Math.max(getLongestPalindromicSubSeq(s1,s2,s1Len-1,s2Len),
                    getLongestPalindromicSubSeq(s1,s2,s1Len,s2Len-1));
        }
    }

    private static String reverse(String s) {

        String reverStr = "";
        for(int  i=s.length()-1; i >= 0; i--){
            reverStr = reverStr + s.charAt(i);
        }
        return reverStr;
    }
}
