package recursion;

/*
SubString is always continuous unlike subsequence.

Ex:
s1 : "pban"
s2: "pgan"
Longest common substring is: "an".

 */
public class LargestCommonSubString {

    public static void main(String[] args) {

        String s1 = "pban";
        String s2 ="pgan";
        String res  = largestCommonSubStr(s1,s2,0,0,"");
        System.out.println(res);
    }

    private static String largestCommonSubStr(String s1, String s2, int s1Index, int s2Index,String subStrWord) {

        if(s1Index >= s1.length() || s2Index >= s2.length() ){
            return subStrWord;
        }
        if(s1.charAt(s1Index) == s2.charAt(s2Index)){
            subStrWord = largestCommonSubStr(s1,s2,s1Index+1,s2Index+1,subStrWord+s1.charAt(s1Index));
        }
        String comb1 =  largestCommonSubStr(s1,s2,s1Index+1,s2Index,"");
        String comb2 = largestCommonSubStr(s1,s2,s1Index,s2Index+1,"");

        if(subStrWord.length() > comb1.length()){
            if (subStrWord.length() > comb2.length()){
                return subStrWord;
            }
            else {
                return comb2;
            }
        }
        if(comb1.length() > comb2.length()) return comb1;
        else return comb2;

    }

}
