package array;

import java.util.HashMap;
import java.util.Map;

/*
Given an array, find if there is any subarray with sum equal to zero.
 */
public class SubArrayWithSumZero {

    public static void main(String[] args) {

        int[] inputArr = new int[]{4,2,-3,1,6};
        int[] inputArr1 = new int[]{4,2,0,1,6};
        int[] inputArr2 = new int[]{-3,2,3,1,6};
        int[] inputArr3 = new int[] {3,-2,-1,4};

        Boolean result1 = subArrayPresentWithSumZero(inputArr);
        System.out.println(result1);
        Boolean result2 = subArrayPresentWithSumZero(inputArr1);
        System.out.println(result2);
        Boolean result3 = subArrayPresentWithSumZero(inputArr2);
        System.out.println(result3);
        Boolean result4 = subArrayPresentWithSumZero(inputArr3);
        System.out.println(result4);

    }

    private static Boolean subArrayPresentWithSumZero(int[] inputArr) {

        int prefixSum = 0;
        Map<Integer,Boolean> prefixSumMap = new HashMap<>();

        for(int i =0; i < inputArr.length; i++){
            prefixSum = prefixSum+inputArr[i];
            if(prefixSum == 0) return true;
            if(!prefixSumMap.containsKey(prefixSum)){
                prefixSumMap.put(prefixSum,true);
            }
            else return true;
        }
        return false;
    }
}
