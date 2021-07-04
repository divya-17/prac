package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*

Given a string S and a value k. Find the longest substring that can be constructed using string S such that
substring is the longest and has only k unique characters in it

Ex:
S = "a a b a c b e b e b e"
k = 3

(a, a, b, a, c, b)-> k unique characters - (a, b, c) -> len = 6
(c, b, e, b, e, b, e) -> k unique characters - (b, c, e) -> len = 7

O/p: 7

 */
public class longestSubStrWithKUniqueCharacters {

    public static void main(String[] args) {

        String str = "aabacbebebe";
        int k = 3;
        int value = getLongestSubstrWithKUniqChars(str, k);

        System.out.println("Result => " + value);
    }

    private static int getLongestSubstrWithKUniqChars(String pattern, int k) {

        HashMap<Character, Integer> charCountMap = new HashMap<>();

        int strt = 0;
        int end = 0;
        int maxLength = 0;

        while (end < pattern.length()) {

            if (!charCountMap.containsKey(pattern.charAt(end))) {
                charCountMap.put(pattern.charAt(end), 1);
            } else {
                charCountMap.put(pattern.charAt(end), charCountMap.get(pattern.charAt(end)) + 1);
            }

            if (charCountMap.keySet().size() == k) {
                maxLength = Math.max(maxLength, (end - strt));
            }

            if (charCountMap.keySet().size() > k) {

                while (charCountMap.keySet().size() > k) {

                    int v = charCountMap.get(pattern.charAt(strt));
                    v = v - 1;
                    if (v != 0) {
                        charCountMap.put(pattern.charAt(strt), v);
                    } else if (v == 0) {
                        charCountMap.remove(pattern.charAt(strt));
                    }
                    strt++;
                }

            }

            end++;
        }


        if(charCountMap.keySet().size() == k){
            maxLength = Math.max(maxLength,end-strt);
        }

    return maxLength;
    }
}


