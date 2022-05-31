package StringQues;

/*
Given s1 and s2, Check if s2 is rotation of s1

Ex: s1 ="ABCD"  s2 ="CDAB"
O/p: true

Ex: s1="ABCD" s2 = "ACBD"
O/p: false
 */
public class StringRotationCheck {


    public static void main(String[] args) {

        String s1 = "ABCD";
        String s2 = "CDAB";

        Boolean result = areRotation(s1,s2);
        System.out.println(result);

    }

    private static boolean areRotation(String s1, String s2) {

        String tempStr = s1+s1;
        if(s1.length() == s2.length() && tempStr.indexOf(s2) != -1){
            return true;
        }
        return false;
    }

}
