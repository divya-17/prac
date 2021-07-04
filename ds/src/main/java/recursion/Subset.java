package recursion;

import java.util.ArrayList;
import java.util.List;

/*

Given a string, find all the possible subsets of that string

Ex: str = "ab"
Possible subsets: "a", "b", "ab", ""


 */
public class Subset {

    private static List<String> allSubsets = new ArrayList<>();

    public static void main(String[] args) {
        String  inputStr = "fun";
        String outStr = "";

        getAllStrSubsets(inputStr,outStr);
        System.out.println(allSubsets);
    }

    private static void getAllStrSubsets(String inputStr, String outStr) {

        if(inputStr.isEmpty()){
            allSubsets.add(outStr);
            return;
        }

        getAllStrSubsets(inputStr.substring(0,inputStr.length()-1),
                inputStr.charAt(inputStr.length()-1)+outStr);

        getAllStrSubsets(inputStr.substring(0,inputStr.length()-1),
                outStr);

    }
}
