package backtracking;
/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombination {


    private static List<String> allPossibleCombinations = new ArrayList();
    private static String inputDigitStr = "23";
    private static Map<String,String> digitToCharMap;

    public static void main(String[] args) {

        digitToCharMap = getPhoneBookHashMap();
        getAllPossiblePhoneBookCombinations(0,"");

        System.out.println("All possible combinations are "+allPossibleCombinations);
    }

    private static void getAllPossiblePhoneBookCombinations(int index,String outputStr) {

        if(outputStr.length() == inputDigitStr.length()){
            allPossibleCombinations.add(outputStr);
            return;
        }
        for(int j =0 ; j < digitToCharMap.get(String.valueOf(inputDigitStr.charAt(index))).length(); j++)
        {
            Character character   = digitToCharMap.get(String.valueOf(inputDigitStr.charAt(index))).charAt(j);
            getAllPossiblePhoneBookCombinations(index+1,outputStr+character);
        }
    }

    private static Map<String, String> getPhoneBookHashMap() {

        Map<String,String> map = new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");

        return map;
    }

}
