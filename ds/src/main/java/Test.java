
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;


public class Test {


    public static void main(String[] args) {


        String  tstStr = "eat";

        char[] tempArr = tstStr.toCharArray();

        Arrays.sort(tempArr);
        System.out.println(new String(tempArr));


        String s1 ="454";
        String s2 = "54";

//        char [] d1Char = s1.toCharArray();
//        char [] d2Char = s2.toCharArray();
//
//        System.out.println(d2Char[0]);
//        System.out.println(d2Char[1]);
//        System.out.println(d2Char[2]);
//
//        Test t = new Test();
//        List<String> result = t.letterCombinations("");
//        System.out.println(result);
    }

    public List<String> letterCombinations(String digits) {

        Map<Integer,String> numberCodeMapping = getNumberCodeMap();
        List<String> allCodeCombinations = null;

        if(digits.length() > 0) {
            allCodeCombinations = getAllKeyBoardCombination(numberCodeMapping, digits);
        }
        else {
            allCodeCombinations = new ArrayList<>();
        }
        return allCodeCombinations;
    }

    public List<String> getAllKeyBoardCombination(Map<Integer,String> numberCodeMapping,String digits){

        // Base Condition
        if(digits.length() == 0 ||
                digits.charAt(0) == '1' ||
                digits.charAt(0) == '0'){

            return new ArrayList(Arrays.asList(""));
        }

        Integer chIntVal = digits.charAt(0) - '0';
        String restOfStr = digits.substring(1);

        List<String> currIterRes = new ArrayList();
        List<String> recurResult = getAllKeyBoardCombination(numberCodeMapping,restOfStr);

        String codeStr = numberCodeMapping.get(chIntVal);

        for(int i = 0; i < codeStr.length(); i++){

            Character codeChar = codeStr.charAt(i);

            for(String word: recurResult){
                currIterRes.add(codeChar+word);
            }

        }

        return currIterRes;
    }

    public Map<Integer,String> getNumberCodeMap(){

        Map<Integer,String> numCodeMap = new HashMap();
        numCodeMap.put(2,"abc");
        numCodeMap.put(3,"def");
        numCodeMap.put(4,"ghi");
        numCodeMap.put(5,"jkl");
        numCodeMap.put(6,"mno");
        numCodeMap.put(7,"pqrs");
        numCodeMap.put(8,"tuv");
        numCodeMap.put(9,"wxyz");

        return numCodeMap;
    }
}
