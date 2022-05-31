package array;

import java.util.HashMap;

/*
Find the number of subarrays in the array whose sum is equal to k.

Ex:
Input Arr: [3, 4, 7, 2, -3, 1, 4, 2]
sum = 7

All subarray combinations:

1- [3,4,]
2- [7]
3- [7, 2, -3, 1]
4- [1, 4, 2]

Ans -> count = 4

 */
public class SubArrayCounts {


    public static void main(String[] args) {

        int [] inputArr = {3, 4, 7, 2, -3, 1, 4, 2};
        int sum = 7;
        int count = getNumberOfSubArrays(inputArr,sum);
        System.out.println("All possible sub arrays  are "+count);
    }

    private static int getNumberOfSubArrays(int[] inputArr, int sum) {

        HashMap<Integer,Integer> prefixSumMap = new HashMap<>();
        int count = 0;
        int prefixSum = 0;

        for(int i=0; i < inputArr.length; i++){

            prefixSum = prefixSum + inputArr[i];

            if (prefixSum == sum){
                count ++;
            }
            else  if(prefixSum > sum){

                if(prefixSumMap.keySet().contains(prefixSum - sum)){
                    count++;
                }
            }
            prefixSumMap.put(prefixSum,1);

        }
        return count;

    }
}
