package stacks;

import java.util.Stack;

/*

How many min paranthesis required so that resulting paranthesis string is valid.

ex:

input: "(()"
op: 1

input: "((("
op: 3

input: "()"
op: 0

input: "()))(("
output: 4

 */
public class MinAddForValidParenthesis {


    public static void main(String[] args) {

        String inputStr = "(()";
        String inputStr1 = "(((";
        String inputStr2 = "()";
        String inputStr3 = "()))((";
        String inputStr4 = "AB";
        int value = minAddToMakeValid(inputStr4);
        System.out.println(value);
    }

    private static int minAddToMakeValid(String inputStr) {

        Stack<Character> chStack = new Stack<>();
        if(inputStr.isEmpty()){
            return 0;
        }
        for(int i = 0; i<inputStr.length();i++){
            if(inputStr.charAt(i) == ')' || inputStr.charAt(i) == '(') {
                if (inputStr.charAt(i) == ')') {
                    if (!chStack.isEmpty() && chStack.peek().equals('(')) {
                        chStack.pop();
                    } else {
                        chStack.push(inputStr.charAt(i));
                    }
                } else {
                    chStack.push(inputStr.charAt(i));
                }
            }
        }
     return chStack.size();
    }

}
