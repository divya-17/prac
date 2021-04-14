package ArraysQues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

Given an array with multiple missing and duplicate numbers, find them all.

Input: arr[] = {3, 1, 3}
Output: Missing = 2, Repeating = 3

Input: arr[] = {4, 3, 6, 2, 1, 1}
Output: Missing = 5, Repeating = 1

 */
public class MissingAndRepeatingNumber {


    public static void main(String[] args) {
        int arr [] = {4,3,6,2,1,1};
        int arr1[] = { 7, 3, 4, 5, 5, 6, 2 };
       // findMissingAndRepeatingUsingHashMap(arr);
        findMissingAndRepeatingUsingTempArr(arr1,arr1.length);
    }

    private static void findMissingAndRepeatingUsingTempArr(int[] arr1, int length) {

        int [] tempArr = new int[arr1.length];

        for(int i =0 ; i < arr1.length ; i++){
            if(tempArr[arr1[i]-1] == 0){
                tempArr[arr1[i]-1] = 1;
            }
            else if (tempArr[arr1[i]-1] == 1){
                System.out.println("Repeating elem "+arr1[i]);
            }
        }

        for(int i=0 ; i < tempArr.length; i++){
            if(tempArr[i] == 0){
                System.out.println("Missing elem "+(i+1));
            }
        }
    }

    private static void findMissingAndRepeatingUsingHashMap(int [] arr) {

        int i;
        Map<Integer,Boolean> map  = new HashMap<>();
        int max = arr.length;

        for(i = 0; i< arr.length; i++){

            if(map.get(arr[i]) == null){
                map.put(arr[i],true);
            }
            else if(map.get(arr[i]) != null){
                System.out.println("Repeating "+arr[i]);
            }
        }

        for(i = 1 ; i < max ; i++){
            if(map.get(i) == null){
                System.out.println("Missing "+i);
            }
        }
    }



}
