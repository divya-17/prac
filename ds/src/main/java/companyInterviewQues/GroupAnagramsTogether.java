package companyInterviewQues;

import scala.util.parsing.combinator.testing.Str;

import java.util.*;

/*
Expedia Interview Ques:

Given an array of strings, group anagrams together.

I/p: ["eat","tea","tan","ate","nat","bat"]
O/p: [["eat","tea","ate"],["tan","nat"] ["bat"]]

 */
public class GroupAnagramsTogether {

    private static Map<String,List<String>> resultMap = new HashMap();
    private static List<List<String>> anagramGrpList = new ArrayList<>();

    public static void main(String[] args) {

        List<String> ipStr = new ArrayList<>();

        ipStr.add("eat");
        ipStr.add("tea");
        ipStr.add("tan");
        ipStr.add("ate");
        ipStr.add("nat");
        ipStr.add("bat");

        groupAllAnagramsTogether(ipStr);
    }

    private static void groupAllAnagramsTogether(List<String> ipStr) {

        for(String word: ipStr){

            String sortedWord = sort(word);
            if(!resultMap.containsKey(sortedWord)){
                resultMap.put(sortedWord,new ArrayList<>(Arrays.asList(word)));
            }
            else{
                resultMap.get(sortedWord).add(word);
            }

        }
        System.out.println(resultMap);
        for(Map.Entry<String,List<String>> entry: resultMap.entrySet()){
            anagramGrpList.add(entry.getValue());
        }
        System.out.println(anagramGrpList);
    }

    private static String sort(String word) {

        char[] charArr = word.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);

    }
}
