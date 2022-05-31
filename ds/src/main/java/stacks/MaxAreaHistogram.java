package stacks;

import java.util.Stack;

/*

Given an array that represents height of measurements in a histogram of uniform width (1unit), find the area
of the largest histogram
 */
public class MaxAreaHistogram {

    public static void main(String[] args) {

        int[] inputArr = new int[] {6, 2, 5, 4, 5, 1, 6};


        Integer maxAreaHistogram = calculateMaxAreaHistogram(inputArr);


        System.out.println("Max area is "+maxAreaHistogram);
    }

    public static Integer calculateMaxAreaHistogram(int[] inputArr) {


        int [] nearestSmallerToLeftIndexArr;
        int[] nearestSmallerToRightIndexArr;


        nearestSmallerToLeftIndexArr = getNSL(inputArr);

        System.out.println("NSL is =>");
        for(int j =0 ; j < nearestSmallerToLeftIndexArr.length; j++){
            System.out.print(nearestSmallerToLeftIndexArr[j]+",");
        }

        System.out.println();

        nearestSmallerToRightIndexArr = getNSR(inputArr);

        System.out.println("NSR is =>");
        for(int j=0; j < nearestSmallerToRightIndexArr.length;j++){
            System.out.print(nearestSmallerToRightIndexArr[j]+",");
        }
        System.out.println();

        Integer maxArea = calculateMaxAreaForEachIndex(nearestSmallerToRightIndexArr,nearestSmallerToLeftIndexArr,inputArr);

        return maxArea;
    }

    private static int calculateMaxAreaForEachIndex(int[] nearestSmallerToRightIndexArr, int[] nearestSmallerToLeftIndexArr, int[] inputArr) {

        int maxHistogramArea =0;

        for(int i =0; i < inputArr.length;i++){

            int strIndex = -1;
            int endIndex = -1;

            if(nearestSmallerToLeftIndexArr[i] == -1){
                strIndex = 0;
            }
            else {
                strIndex = nearestSmallerToLeftIndexArr[i]+1;
            }

            if(nearestSmallerToRightIndexArr[i] == -1){
                endIndex = inputArr.length-1;
            }
            else {
                endIndex = nearestSmallerToRightIndexArr[i]-1;
            }

            int area = inputArr[i]*((endIndex-strIndex)+1);

            if(area > maxHistogramArea){
                maxHistogramArea = area;
            }
        }

        return maxHistogramArea;
    }

    private static int[] getNSL(int[] inputArr) {


        int [] nearestSmallerToLeftIndexArr = new int[inputArr.length];

        Stack<Integer> minStack = new Stack();


        for(int i =0; i < inputArr.length; i++){

            while (!minStack.isEmpty() && inputArr[minStack.peek()] >= inputArr[i]){
                minStack.pop();
            }

            if(minStack.isEmpty()){
                nearestSmallerToLeftIndexArr[i] = -1;
            }
            else {
                nearestSmallerToLeftIndexArr[i] = minStack.peek();
            }
            minStack.push(i);
        }
        return nearestSmallerToLeftIndexArr;

    }

    private static int[] getNSR(int[] inputArr) {

        Stack<Integer> minStack = new Stack<>();
        int [] nearestSmallerToRightIndexArr = new int[inputArr.length];

        for(int i =inputArr.length-1; i >= 0; i--){

            while (!minStack.isEmpty() && inputArr[minStack.peek()] >= inputArr[i]){
                minStack.pop();
            }

            if(minStack.isEmpty()){
                nearestSmallerToRightIndexArr[i] = -1;
            }
            else {
                nearestSmallerToRightIndexArr[i] = minStack.peek();
            }
            minStack.push(i);
        }
        return nearestSmallerToRightIndexArr;
    }

}
