package dynamicProgramming.knapsackAndVariations;

/*
Given a string, find the length of longest repeating subsequence such that two subsequence don't have
same character at same position i.e any ith character in two sequences shouldn't have same sequence.

 Ex: "AABEBCDD"
 o/p: 3 [ABD]

 Ex: "AABB"
 o/p: 2 [AB]

 Ex: "AXXXY"
 o/p: 2[XX]
 */
public class LongestRepeatingSubSequence {

    public static void main(String[] args) {

        String s = "AABEBCDD";
        String revs = reverse(s);
        int res = getLongestRepeatingSubSeq(s,revs,s.length()-1,revs.length()-1);

        System.out.println("Result "+res);
    }

    private static String reverse(String s) {

        String newStr = "";
        for(int i = s.length()-1; i >= 0; i--){
            newStr = newStr+s.charAt(i);
        }
        return newStr;
    }

    private static int getLongestRepeatingSubSeq(String s1, String s2, int s1Len, int s2Len) {

        if(s1Len == 0 || s2Len == 0){
            return 0;
        }
        if(s1.charAt(s1Len) == s2.charAt(s2Len) && s1Len != s2Len){
            return 1+getLongestRepeatingSubSeq(s1,s2,s1Len-1,s2Len-1);
        }
        else{
            return Math.max(getLongestRepeatingSubSeq(s1,s2,s1Len-1,s2Len),
                    getLongestRepeatingSubSeq(s1,s2,s1Len,s2Len-1));
        }
    }
}
