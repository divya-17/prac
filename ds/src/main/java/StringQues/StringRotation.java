package StringQues;

/*

Rotation of string means moving the left most character to the right most position.

Ex: "abcde" => it will be => "bcdea" after shifting "a" by one position.

Given two string s1 and s2, return true if s1 can become s2 after any number of shifts.

Ex: s1 = "abcde"
    s2 = "cdeab"
    => return true.


Ex: s1 = "abcde"
    s2 = "abced"
    => return false

    Using KMP algorithm


 */

public class StringRotation {


    public static void main(String[] args) {

//        String actualStr = "abcde";
//        String rotatedStr = "cdeab";

        String actualStr = "abcde";
        String rotatedStr = "abced";

        Boolean found =rotatedString(actualStr,rotatedStr);
        System.out.println(found);

    }

    private static Boolean rotatedString(String actualStr, String rotatedStr) {

        /*
        concatenated the actual str. Rotated str will also be the substring of this concatenated string
         */
        if(actualStr.isEmpty() && rotatedStr.isEmpty()){
            return true;
        }

        if(actualStr.length() != rotatedStr.length()){
            return false;
        }
        String completeStrPattern = actualStr+actualStr;

        for(int i=0; i < completeStrPattern.length(); i++){

            if(completeStrPattern.charAt(i) == rotatedStr.charAt(0)){

                int k =0;
                int j=i;

                while (k < rotatedStr.length() && completeStrPattern.charAt(j) == rotatedStr.charAt(k)){
                    k++;
                    j++;
                }

               if(k == rotatedStr.length()){
                   return true;
               }
            }
        }

        return false;
    }
}
