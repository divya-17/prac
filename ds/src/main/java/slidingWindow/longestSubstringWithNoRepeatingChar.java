package slidingWindow;

import java.util.*;

public class longestSubstringWithNoRepeatingChar {

    public static void main(String[] args) {

        String str = "pwwkew";
        int output = getLongestSubstrWithUniqChars(str);
        System.out.println(output);
    }

    private static int getLongestSubstrWithUniqChars(String str) {

        int maxLen = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        while (end < str.length()) {


            if (!charMap.containsKey(str.charAt(end))) {
                charMap.put(str.charAt(end), 1);
            } else {
                charMap.put(str.charAt(end), charMap.get(str.charAt(end)) + 1);
            }

            if (charMap.size() == (end - start + 1)) {
                maxLen = Math.max(maxLen, (end - start + 1));
            }

            if (charMap.size() < (end - start + 1)) {

                while (charMap.size() < (end - start + 1)) {

                    if (charMap.containsKey(str.charAt(start))) {
                        int v = charMap.get(str.charAt(start));
                        v = v - 1;
                        if (v == 0) {
                            charMap.remove(str.charAt(start));
                        } else {
                            charMap.put(str.charAt(start), v);
                        }
                    }
                    start++;

                }

            }
            end++;
        }
      return maxLen;
    }

}
