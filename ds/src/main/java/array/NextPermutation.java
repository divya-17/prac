package array;

import java.util.Arrays;

/*
Given an array of number, find the lexicographically next higher number. If no next higher
number is possible then print all numbers in ascending order.

ex: [1,3,2]
o/p: [2,1,3]

ex:[1,5,8,4,7,6,5,3,1]
o/p:[1,5,8,5,1,3,4,6,7]

 */
public class NextPermutation {

    public static void main(String[] args) {

        int[] inputArr = new int[] {1,5,8,4,7,6,5,3,1};
        int[] inputArr1 = new int[] {3,2,1};
        int[] outputArr = getNextHigherNumber(inputArr1);

        System.out.println("Result: ");
        for(int i =0; i < outputArr.length; i++){
            System.out.print(outputArr[i]+",");
        }
        System.out.println();
    }

    private static int[] getNextHigherNumber(int[] inputArr) {

        int targetIndex = -1;
        int nextHigherIndex = -1;

        for(int i =inputArr.length-2; i >= 0; i--){
            if(inputArr[i] < inputArr[i+1]){
                targetIndex = i;
                break;
            }
        }
        if(targetIndex == -1){
            reverseArr(inputArr,0,inputArr.length-1);
        }
        else{
            nextHigherIndex = targetIndex+1;
            for(int i = targetIndex+1; i < inputArr.length; i++){
                if(inputArr[i] > inputArr[targetIndex] && inputArr[i] < inputArr[nextHigherIndex]){
                    nextHigherIndex = i;
                }
            }
            swap(inputArr,targetIndex,nextHigherIndex);

            Arrays.sort(inputArr,targetIndex+1,inputArr.length);
        }


        return inputArr;
    }

    private static void swap(int[] inputArr, int index1, int index2) {

        int temp = inputArr[index1];
        inputArr[index1] = inputArr[index2];
        inputArr[index2] = temp;
    }

    private static void reverseArr(int[] inputArr, int strt, int end) {

        for(int i = strt; i <= strt+(end-strt/2); i++){
            swap(inputArr,i,end);
            end--;
        }
    }
}
