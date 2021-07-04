package recursion;

import java.util.ArrayList;
import java.util.List;

/*
Generate all permutation of spaces between characters of a string

Ex: I/p Str: "ABC"
O/p: ["A_B_C","A_BC","AB_C","ABC"]


 */
public class PermutationWithSpaces {

    private static List<String> result = new ArrayList<>();
    private static String originalStr = "ABC";

    public static void main(String[] args) {
        
        generateAllPermutationWithSpaces(originalStr,originalStr);
        System.out.println(result);
    }

    private static void generateAllPermutationWithSpaces(String inputStr, String outputStr) {

        if(inputStr.length() == 1){
            result.add(outputStr);
            return;
        }

        Character targetStr = inputStr.charAt(0);
        StringBuffer outStr = new StringBuffer();
        for(int i = 0; i < outputStr.length(); i++){
            outStr.append(outputStr.charAt(i) == targetStr?outputStr.charAt(i)+"_":outputStr.charAt(i));
        }

        generateAllPermutationWithSpaces(inputStr.substring(1),
                    outStr.toString());



        generateAllPermutationWithSpaces(inputStr.substring(1), outputStr);
    }

}
