package StringQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a string, print all subsequences of that string.
ex:
ipStr: "abc"
opStr: ["","a","b","c","ab","ac","bc","abc"]
 */
public class PrintAllSubSeqOfStr {

    public static void main(String[] args) {

        String ipStr = "abc";
        getAllSubSequencesOfStr(ipStr,"");
    }

    private static void  getAllSubSequencesOfStr(String ipStr,String outStr) {

        if(ipStr.isEmpty()){
            System.out.println(outStr);
            return;
        }

        Character ch = ipStr.charAt(0);
        String ros = ipStr.substring(1);

        getAllSubSequencesOfStr(ros,outStr+ch);
        getAllSubSequencesOfStr(ros,outStr);

    }
}
