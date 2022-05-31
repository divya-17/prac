package StringQues;

import java.util.ArrayList;
import java.util.List;

/*
Given a string, print all possible permutation of that string.
 */
public class PrintAllPermutation {

    private static List<String> finalRes = new ArrayList();

    public static void main(String[] args) {

        String ipStr = "123";

        getAllPermutationsOfStr(ipStr,"");

        System.out.println(finalRes);

    }

    private static void getAllPermutationsOfStr(String ipStr,String outStr) {

        if(ipStr.isEmpty()){
            finalRes.add(outStr);
            return;
        }
        for(int i =0; i < ipStr.length(); i++){

            Character currChar = ipStr.charAt(i);
            String ros = ipStr.substring(0,i)+ipStr.substring(i+1);

            getAllPermutationsOfStr(ros,outStr+currChar);
        }
    }
}
