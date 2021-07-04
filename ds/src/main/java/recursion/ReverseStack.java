package recursion;

import java.util.Stack;

/*
Reverse a stack using recursion without using any additional storage.

 */
public class ReverseStack {

    public static void main(String[] args) {

        Stack<Integer> inputStack = new Stack<>();

        inputStack.push(1);
        inputStack.push(2);
        inputStack.push(3);
        inputStack.push(4);
        inputStack.push(5);


        System.out.println("Input stack => "+inputStack);
        Stack<Integer> reversedStack = reverseStack(inputStack,inputStack.size());
        //System.out.println("Reversed stack length is "+reversedStack.size());
        System.out.println("Reversed stack => "+reversedStack);
//        System.out.println(reversedStack);
    }

//    private static void printStack(Stack<Integer> inputStack) {
//
//        System.out.println("Print stack called !");
//        Stack<Integer> tempStack = (Stack<Integer>)inputStack.clone();
//        while(!tempStack.isEmpty()){
//            System.out.println(tempStack.pop());
//        }
//    }

    private static Stack<Integer> reverseStack(Stack<Integer> inputStack, Integer n) {

        if(n == 0){
            return inputStack;
        }
        int top =inputStack.pop();

        reverseStack(inputStack, n-1);
        pushToBottom(inputStack,top);

        return inputStack;
    }

    private static void pushToBottom(Stack<Integer> inputStack, int elem) {

        if(inputStack.isEmpty()){
            inputStack.push(elem);
            return;
        }

        int temp = inputStack.pop();
        pushToBottom(inputStack, elem);
        inputStack.push(temp);
        return;
    }

}
