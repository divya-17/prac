package stacks;

import java.util.Stack;

/*
Given an array of elems, find the min elem in the stack(while pushing these elems in stack) using O(1) space.
 */
public class MinElemInStack {

    private static int minElem = 0;

    public static void main(String[] args) {

        int[] inputArr = new int[]{4, 9, 5, 2, 7, 1, 8};
        Stack<Integer> minStack = new Stack<>();

        for(int i=0; i < inputArr.length; i++){
            if(minStack.isEmpty()){
                minElem = inputArr[i];
                minStack.push(inputArr[i]);
            }
            else {
                if (inputArr[i] < minElem){
                    minStack.push(2*inputArr[i]-minElem);
                    minElem = inputArr[i];
                }
                else if(inputArr[i] >= minElem){
                    minStack.push(inputArr[i]);
                }
            }

        }
        while (!minStack.isEmpty()){
            int poppedElem = minStack.pop();
//            System.out.println("Popped elem is "+poppedElem+" and min elem is "+minElem);
            System.out.println("Popped elem "+getActualValue(poppedElem));
            System.out.println("Min elem is "+minElem);
        }
    }

    private static int getActualValue(int poppedElem) {
        if(poppedElem < minElem){
            int actualValue = minElem;
            minElem = (2*minElem-poppedElem);
            return actualValue;
        }
        else {
            return poppedElem;
        }
    }


}
