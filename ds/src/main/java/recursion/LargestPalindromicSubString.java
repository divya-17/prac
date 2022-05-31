package recursion;

/*
Given string s, find the largest palindromic substring
Ex: s ="babad"
Output : 3 => (aba or bab)

Ex: s = "cbbd"
output: 2 => (bb)

 */
public class LargestPalindromicSubString {

    public static void main(String[] args) {


        String s = "babad";
        int result  = getLengthOfLargestPalindromicSubStr(s,0,s.length()-1);

        System.out.println(result);
    }

    private static int getLengthOfLargestPalindromicSubStr(String s,int start, int end) {

        if(start > end){
            return 0;
        }
        if(start == end){
            return 1;
        }
        if(s.charAt(start) == s.charAt(end)){
            return 2+getLengthOfLargestPalindromicSubStr(s,start+1,end-1);
        }
        else{
            return Math.max(getLengthOfLargestPalindromicSubStr(s,start+1,end),
                    getLengthOfLargestPalindromicSubStr(s,start,end-1));
        }
    }
}
