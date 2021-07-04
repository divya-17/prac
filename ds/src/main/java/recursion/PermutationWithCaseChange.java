package recursion;

import java.util.ArrayList;
import java.util.List;

/*

Given an input string: "ab"
Generate all permutations of case change of this string like:
["Ab","aB","AB","ab"]

 */
public class PermutationWithCaseChange {

    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {

        String inputStr = "ab";
        String outputStr = inputStr;

        permutationWithCaseChanges(inputStr,outputStr);
        System.out.println(result);
    }

    private static void permutationWithCaseChanges(String inputStr, String outputStr) {

        if(inputStr.length() == 0){
            result.add(outputStr);
            return;
        }

        Character targetChar = inputStr.charAt(0);
        StringBuffer outStr = new StringBuffer();
        for(int i =0; i < outputStr.length(); i++){
            outStr.append(outputStr.charAt(i)== targetChar?
                    String.valueOf(outputStr.charAt(i)).toUpperCase():outputStr.charAt(i));
        }
        permutationWithCaseChanges(inputStr.substring(1), outputStr);

        permutationWithCaseChanges(inputStr.substring(1), outStr.toString());

    }
}
