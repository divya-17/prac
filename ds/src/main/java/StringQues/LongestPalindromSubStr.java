package StringQues;

import javafx.util.Pair;

/*
Given a string S, find a longest substring that satisfies palindromic condition(longest palindromic substring)

Ex:

S : "aaaabbaa"
Output: "aabbaa"


S: "babad"
Output: "bab"

 */
public class LongestPalindromSubStr {

    public static void main(String[] args) {


        String inputStr = "aaaabbaa";

        if (inputStr.length() > 2) {
            Pair<Integer, Integer> indexPair = getLongestPalindromicSubStr(inputStr);

            System.out.println("Longest palindrom in the string is ");
            for(int start = indexPair.getKey(); start <= indexPair.getValue(); start++){
                System.out.print(inputStr.charAt(start)+ " ");
            }
            System.out.println();

        }

    }

    private static Pair<Integer, Integer> getLongestPalindromicSubStr(String inputStr) {

        int lowerIndex = 0;
        int upperIndex = 0;

        // Even palindromic str

        for (int i = 0; i < inputStr.length() - 1; i++) {

            if (i + 1 >= inputStr.length()) {
                break;
            }
            if (inputStr.charAt(i) == inputStr.charAt(i + 1)) {


                int startIndex = i;
                int endIndex = i + 1;

                if (startIndex != 0 && endIndex != inputStr.length() - 1) {
                    while (startIndex >= 0 &&
                            endIndex <= (inputStr.length() - 1)
                            && startIndex != endIndex
                            && inputStr.charAt(startIndex) == inputStr.charAt(endIndex)) {

                        startIndex--;
                        endIndex++;
                    }

                    if (lowerIndex == 0 && upperIndex == 0) {
                        lowerIndex = startIndex + 1;
                        upperIndex = endIndex - 1;
                    } else {
                        if ((upperIndex - lowerIndex) < ((endIndex - 1) - (startIndex + 1))) {

                            lowerIndex = startIndex + 1;
                            upperIndex = endIndex - 1;
                        }
                    }
                } else {
                    if ((upperIndex - lowerIndex) < (endIndex - startIndex)) {
                        lowerIndex = startIndex;
                        upperIndex = endIndex;
                    }
                }

            }
        }

        // Odd palindromic str

        for (int i = 0; i < inputStr.length() - 1; i++) {

            if (i + 2 >= inputStr.length()) {
                break;
            }
            if (inputStr.charAt(i) == inputStr.charAt(i + 2)) {

                int startIndex = i;
                int endIndex = (i + 2);

                while (startIndex >= 0 && endIndex <= (inputStr.length() - 1)
                        && startIndex != endIndex
                        && inputStr.charAt(startIndex) == inputStr.charAt(endIndex)) {

                    startIndex--;
                    endIndex++;
                }

                if ((upperIndex - lowerIndex) < ((endIndex - 1) - (startIndex + 1))) {

                    lowerIndex = startIndex + 1;
                    upperIndex = endIndex - 1;
                }

            }

        }

        return new Pair<>(lowerIndex, upperIndex);
    }
}
