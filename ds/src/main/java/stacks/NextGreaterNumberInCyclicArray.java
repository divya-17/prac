package stacks;

import java.util.Stack;

/*

https://leetcode.com/problems/next-greater-element-ii/

Input: nums = [1,2,1]
Output: [2,-1,2]

Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 */
public class NextGreaterNumberInCyclicArray {


    public static void main(String[] args) {

        //int [] arr = {1, 6, 7, 2, 5, 8, 3, 4};

        //int [] arr = {1, 2, 3, 4, 3};

        int[] arr = {100, 1, 11, 1, 120, 111, 123, 1, -1, -100};

        //int[] arr = {0, -2, -3};

        nextHigherElemInCyclicArr(arr);
    }

    private static void nextHigherElemInCyclicArr(int[] arr) {

        int[] ansArr = new int[arr.length];

        Stack<Integer> nextHigherNumStack = new Stack();

        for (int i = 0; i < arr.length; i++) {


            if (!nextHigherNumStack.isEmpty()) {

                if (arr[i] > arr[nextHigherNumStack.peek()]) {

                    while (!nextHigherNumStack.isEmpty() && arr[nextHigherNumStack.peek()] < arr[i]) {
                        int topIndex = nextHigherNumStack.pop();
                        ansArr[topIndex] = arr[i];
                    }

                    nextHigherNumStack.push(i);
                } else {
                    nextHigherNumStack.push(i);
                }

            } else {
                nextHigherNumStack.push(i);
            }

        }

        while (!nextHigherNumStack.isEmpty()) {

            int elem = nextHigherNumStack.pop();

            boolean nextHigherElemFound = false;

            for (int j = 0; j < elem; j++) {

                if (arr[j] > arr[elem]) {

                    ansArr[elem] = arr[j];
                    nextHigherElemFound = true;
                    break;
                }
            }
            if (!nextHigherElemFound) {
                ansArr[elem] = -1;
            }
        }

        for(int i =0; i < ansArr.length; i++){
            System.out.print(ansArr[i] + " , ");
        }


    }


}
