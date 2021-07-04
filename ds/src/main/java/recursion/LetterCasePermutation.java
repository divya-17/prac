package recursion;

import java.util.ArrayList;
import java.util.List;

/*
Given a string with letters and digits, generate all permutations of lowercase version of letters
without modifying the digits.

Ex: String str = "a1B2"

O/p: ["a1b2","a1B2","A1b2","A1B2"]

 */
public class LetterCasePermutation {


    public static void main(String[] args) {

        String inputStr = "a1B2c";
        String outputStr = "a1B2c";

        List<String> result = new ArrayList<>();
        getAllLetterCasePermutations(inputStr, outputStr, result);

        System.out.println("Result is "+result);
    }

    private static List<String> getAllLetterCasePermutations(String inputStr, String outputStr, List<String> result) {

        if(inputStr.length() == 0){
            result.add(outputStr);
            return result;
        }

        Character targetChar = inputStr.charAt(0);
        if(Character.isDigit(targetChar)){
            getAllLetterCasePermutations(inputStr.substring(1), outputStr,result);
        }
        else {
            StringBuffer outStr = new StringBuffer();
            for(int i=0; i < outputStr.length(); i++){
                outStr.append(outputStr.charAt(i) == targetChar?

                        (Character.isUpperCase(outputStr.charAt(i))?
                        String.valueOf(outputStr.charAt(i)).toLowerCase():
                        String.valueOf(outputStr.charAt(i)).toUpperCase()):

                        outputStr.charAt(i));
            }
            getAllLetterCasePermutations(inputStr.substring(1), outStr.toString(),result);

            getAllLetterCasePermutations(inputStr.substring(1), outputStr,result);
        }

        return result;
    }

}
