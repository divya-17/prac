import java.util.*;

public class RoughTest {

    private Boolean possibilityFlag = false;
    public static void main(String[] args) {

        RoughTest test = new RoughTest();

        String s  = "leetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet","code"));

        Boolean result  = test.wordBreak(s,wordDict);
        System.out.println(result);

    }

    private Boolean wordBreak(String s, List<String> wordDict) {

        Map<Character,List<String>> charToWordMap=getChartoWordMap(wordDict);
        System.out.println(charToWordMap);
        Boolean result = checkWordBreak(0,s,charToWordMap);
        return result;

    }

    private Boolean checkWordBreak(int index, String s, Map<Character, List<String>> charToWordMap) {

        if(index == s.length()){
            return true;
        }
        Character ch = s.charAt(index);

        if(charToWordMap.get(ch) == null){
            return false;
        }
        else{
            for(String word: charToWordMap.get(ch)){

                if(index+word.length() <= s.length()){

                    String currWordSegment = s.substring(index,index+word.length());

                    if(currWordSegment.equals(word)){
                        if(checkWordBreak(index+word.length(),s,charToWordMap)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private Map<Character, List<String>> getChartoWordMap(List<String> wordDict) {

        Map<Character,List<String>> charToWordMap = new HashMap();

        for(String word: wordDict){

            if(charToWordMap.containsKey(word.charAt(0))){
                List<String> currList = charToWordMap.get(word.charAt(0));
                currList.add(word);
            }
            else{
                charToWordMap.put(word.charAt(0),new ArrayList(Arrays.asList(word)));
            }
        }

        return charToWordMap;
    }
}
