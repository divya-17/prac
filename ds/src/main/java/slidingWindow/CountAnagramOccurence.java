package slidingWindow;

/*

Given a long string and another string pattern, find out the number of anagram occurence of small string pattern
in the long string

Ex:

Str = "a a b a a b a a"
pattern = " a a b a"

O/p anagram combinations:

(a a b a)
(a b a a)
(a a b a)
(a b a a)
output count: 4

 */

import java.util.HashMap;
import java.util.Map;

public class CountAnagramOccurence {

    public static void main(String[] args) {

        String searchStr = "aabaabaa";
        String anagramPattern = "aaba";


        int count = getCountOfAnagramPatterns(searchStr, anagramPattern);
        System.out.println("Count is " + count);
    }

    private static int getCountOfAnagramPatterns(String searchStr, String anagramPattern) {

        int anagramOccurenceCount = 0;

        Map<Character, Integer> characterCountMap = new HashMap<>();

        for (int i = 0; i < anagramPattern.length(); i++) {


            if (!characterCountMap.containsKey(anagramPattern.charAt(i))) {
                characterCountMap.put(anagramPattern.charAt(i), 1);
            } else {
                characterCountMap.put(anagramPattern.charAt(i), characterCountMap.get(anagramPattern.charAt(i)) + 1);
            }
        }

        Map<Character, Integer> windowCharacterCountMap = new HashMap<>();


        int strt = 0;
        int end = 0;

        while (end < searchStr.length()) {

            if (!windowCharacterCountMap.containsKey(searchStr.charAt(end))) {
                windowCharacterCountMap.put(searchStr.charAt(end), 1);
            } else {
                windowCharacterCountMap.put(searchStr.charAt(end),
                        windowCharacterCountMap.get(searchStr.charAt(end)) + 1);
            }

           if ((end - strt + 1) == anagramPattern.length()) {

                if (windowCharacterCountMap.equals(characterCountMap)) {
                    anagramOccurenceCount++;
                }
                windowCharacterCountMap.put(searchStr.charAt(strt),
                        windowCharacterCountMap.get(searchStr.charAt(strt)) - 1);


                strt++;
            }

            end++;

        }
        return anagramOccurenceCount;
    }

}
