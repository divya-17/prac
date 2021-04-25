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

        int [] arr = {1, 6, 7, 2, 5, 8, 3, 4};
        cyclicArr(arr);
    }

    private static void cyclicArr(int[] arr) {

        int[] ansArr = new int[arr.length];
        Stack nextHigherNumStack = new Stack();

        int index = 0;
        while (index < arr.length){
            for (int i=index+1; i < arr.length; i++){
                if(!nextHigherNumStack.isEmpty()){
                    if(arr[i] > Integer.parseInt(nextHigherNumStack.peek().toString())){

                    }
                }
            }
            for(int j = 0; j < index; j++){
                System.out.print(arr[j]+" , ");
            }
            System.out.println();
            index++;

        }

    }
}
