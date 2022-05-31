package stacks;

import java.util.Stack;

/*

Given an array of numbers that denote the height of pillars, calculate total area in which water will be collected
if it's raining over that structure.
 */
public class RainTrappingProblem {


    public static void main(String[] args) {

        int[] arr = new int[]{ 3, 0, 0, 2, 0, 4 };
        int area = getTotalWaterArea(arr);
        System.out.println("Total water area will be "+area);

    }


    private static int getTotalWaterArea(int[] arr) {

        int totalArea = 0;

        int [] maxToRightArr = getMaxToRight(arr);
        int [] maxToLeftArr = getMaxToLeft(arr);


        for(int i =0; i < arr.length; i++){
            if(maxToLeftArr[i] != -1 && maxToRightArr[i] != -1) {
                int minHeight = Math.min(maxToLeftArr[i], maxToRightArr[i]);
                totalArea = totalArea+(minHeight - arr[i]);
            }
        }
        return totalArea;
    }

    private static int[] getMaxToLeft(int[] arr) {

        Stack<Integer> maxToLeftStack = new Stack<>();

        int[] maxToLeftArr = new int[arr.length];


        for(int i=0; i < arr.length;i++){

            while (!maxToLeftStack.isEmpty() && maxToLeftStack.peek() < arr[i]){
                maxToLeftStack.pop();
            }

            if(maxToLeftStack.isEmpty()) {
                maxToLeftStack.push(arr[i]);
                maxToLeftArr[i] = -1;
            }
            else if(maxToLeftStack.peek() > arr[i]){
                maxToLeftArr[i] = maxToLeftStack.peek();
            }
        }
        return maxToLeftArr;
    }

    private static int[] getMaxToRight( int[] arr) {


        int[] maxToRightArr = new int[arr.length];

        Stack<Integer> maxToRightStack= new Stack<>();

        for(int i=arr.length-1; i >= 0;i--){

            while (!maxToRightStack.isEmpty() && maxToRightStack.peek() < arr[i]){
                maxToRightStack.pop();
            }

            if(maxToRightStack.isEmpty()) {
                maxToRightStack.push(arr[i]);
                maxToRightArr[i] = -1;
            }
            else if(maxToRightStack.peek() > arr[i]){
                maxToRightArr[i] = maxToRightStack.peek();
            }
        }
        return maxToRightArr;
    }
}
