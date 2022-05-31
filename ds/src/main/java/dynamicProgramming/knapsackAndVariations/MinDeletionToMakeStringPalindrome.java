package dynamicProgramming.knapsackAndVariations;

/*

https://www.youtube.com/watch?v=CFwCCNbRuLY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=27
Min number of deletion required to make string palindrome.
Str = "abcgcba"
Min deletion = 1

Note: Number of insertions = Number of deletions in order to make string palindromic.


 */
public class MinDeletionToMakeStringPalindrome {

    public static void main(String[] args) {

        String s = "abgccba";
        int lpsLen = getLongestPalindromicSubSeq(s,reverse(s),s.length()-1,s.length()-1);
        System.out.println(lpsLen);
        System.out.println("Min number of deletion =>"+(s.length()-lpsLen));
    }

    private static int getLongestPalindromicSubSeq(String s1, String s2, int s1Len, int s2Len) {

        if(s1Len < 0 || s2Len < 0){
            return 0;
        }
        if(s1.charAt(s1Len) == s2.charAt(s2Len)){
            return 1+getLongestPalindromicSubSeq(s1,s2,s1Len-1,s2Len-1);
        }
        else{
            return Math.max(getLongestPalindromicSubSeq(s1,s2,s1Len-1,s2Len),
                    getLongestPalindromicSubSeq(s1,s2,s1Len,s2Len-1));
        }
    }

    private static String reverse(String s) {

        String reverseStr = "";
        for (int i = s.length()-1; i >=0; i--){
            reverseStr = reverseStr+s.charAt(i);
        }
        return reverseStr;
    }
}
