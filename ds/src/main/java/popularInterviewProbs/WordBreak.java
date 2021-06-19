package popularInterviewProbs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Given a string s and a dictionary of strings wordDict,
return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Exmp:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code


Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


 */
public class WordBreak {

    public static void main(String[] args) {

        List<String> wordDict = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        String word = "catsandog";

        int index = 0;
        Boolean result = wordBreak(word, wordDict, index);

    }

    private static Boolean wordBreak(String word, List<String> wordDict, int index) {

        List<Boolean> allResult = new ArrayList<Boolean>();

        if (index == word.length()) {
            return true;
        }

        for (String dictWord : wordDict) {
            if (dictWord.startsWith(String.valueOf(word.charAt(index)))) {
                if ((word.substring(index, index + dictWord.length()).equals(dictWord))) {
                    allResult.add(wordBreak(word, wordDict, index + dictWord.length()));
                }
            }

        }

        if (allResult.contains(true)) {
            return true;
        }
        return false;
    }
}
