package backtracking;

import java.util.ArrayList;
import java.util.List;


public class generateParantheses {

    static List<String> finalOutput = new ArrayList<>();

    public static void main(String[] args) {

        int input = 3;
        createParanthesisStrs(2,2,"");
        System.out.println("Final paranthesis strs are "+finalOutput);
    }

    private static void createParanthesisStrs(int open, int close, String outStr) {

        if(open == 0 && close == 0){
            finalOutput.add(outStr);
            return;
        }
        if(open == close){
         createParanthesisStrs(open-1,close,outStr+"(");
        }
        else if(open == 0){
            createParanthesisStrs(open,close-1,outStr+")");
        }
        else if(open < close){
            createParanthesisStrs(open-1,close,outStr+"(");
            createParanthesisStrs(open,close-1,outStr+")");
        }

    }
}

