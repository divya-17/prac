package dynamicProgramming.knapsackAndVariations;
/*
Min number of insertion and deletion required to convert string s1 to string s2

s1 = "heap";
s2 = "pea";
o/p:
min insertion = 1
min deletion = 2

 */
public class MinInsertionDeletion {

    public static void main(String[] args) {

        String s1 ="heap";
        String s2 = "pea";

        int lscCount = getLongestCommSubSeq(s1,s2,s1.length()-1,s2.length()-1);
        System.out.println(lscCount);
        int minNumDeletions = s1.length()-lscCount;
        int minNumInsertions = s2.length()-lscCount;
        System.out.println("Min Deletion =>"+minNumDeletions);
        System.out.println("Min Insertion => "+minNumInsertions);
    }

    private static int getLongestCommSubSeq(String s1, String s2, int s1Len, int s2Len) {

        if(s1Len < 0 || s2Len < 0){
            return 0;
        }
        if(s1.charAt(s1Len) == s2.charAt(s2Len)){
            return 1+getLongestCommSubSeq(s1,s2,s1Len-1,s2Len-1);
        }
        else{
            return Math.max(getLongestCommSubSeq(s1,s2,s1Len-1,s2Len),
                    getLongestCommSubSeq(s1,s2,s1Len,s2Len-1));

        }
    }
}
