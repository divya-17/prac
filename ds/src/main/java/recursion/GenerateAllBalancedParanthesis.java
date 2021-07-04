package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*

Given an input number n, we can use n- combination of closing and opening paranthesis pairs
Ex: n= 2 means we can use 2 closing "))" and 2 opening "((" paranthesis pairs.

Using this generate all possible balanced paranthesis strings.

 */
public class GenerateAllBalancedParanthesis {

    public static void main(String[] args) {

        int n = 3;
        Stack<Character> stack = new Stack<Character>();
        List<String> allPossibleParanthesis = new ArrayList<>();

        int open = n;
        int close = n;
        //generateBalancedParenthesis("",2*n,allPossibleParanthesis,stack);
        generateBalancedParenthesisEffective(open,close,"",allPossibleParanthesis);

        System.out.println(allPossibleParanthesis);

    }

    private static void generateBalancedParenthesisEffective(int open, int close,
                                                             String outStr,
                                                             List<String> resultList) {
        if(open == 0 && close == 0){
            resultList.add(outStr);
            return;
        }

        if(open != 0){
            generateBalancedParenthesisEffective(open-1,close,outStr+"(",resultList);
        }
        if(close > open){
            generateBalancedParenthesisEffective(open, close-1, outStr+")",resultList);        }

    }

    // This method is not efficient as it takes all possible paths into consideration.
    private static void generateBalancedParenthesis(String outStr, int n,List<String> result,Stack<Character> stack) {


        if(n==0){
            for(int i =0 ; i < outStr.length(); i++){
                if(!stack.isEmpty() &&
                        (outStr.charAt(i) == ')' && stack.peek()=='(')){
                    stack.pop();
                }
                else {
                    stack.push(outStr.charAt(i));
                }
            }
            if(stack.isEmpty()) {
                result.add(outStr);
            }
            stack.clear();
            return;
        }

        generateBalancedParenthesis(outStr+"(", n-1,result,stack);
        generateBalancedParenthesis(outStr+")", n-1,result,stack);
    }
}
