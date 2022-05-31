package StringQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] args) {

        ValidParanthesis obj = new ValidParanthesis();
        String s = "{[]}";
        Boolean result = obj.isValidParanthesis(s);
        System.out.println(result);
        
    }

    private Boolean isValidParanthesis(String s) {
        List<Character> validOpenBrackets = new ArrayList(Arrays.asList('(','{','['));
        Stack<Character> charStack = new Stack();

        for(int i =0; i < s.length(); i++){
            Character currChar = s.charAt(i);

            if(validOpenBrackets.contains(currChar)){
                charStack.push(currChar);
            }

            else{
                if(charStack.isEmpty()){
                    return false;
                }

                Character topChar = charStack.pop();
                if(currChar == ')' && topChar == '(' || currChar == '}' && topChar == '{' || currChar == ']' && topChar == '[')
                    continue;
                else
                    return false;


            }
        }
        if(!charStack.isEmpty()) return false;
        else return true;    }
}
