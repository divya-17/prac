package ArraysQues;

/*
Given an unsorted array of both +ve and -ve numbers, find the maximum sum that can be created by a subarray

Youtube explaination: https://www.youtube.com/watch?v=86CQq3pKSUw

Ex:
arr1  = {1, -3, 2, 1, -1}
Max sum will be result of subarray {2,1} => 3
O/p: 3

arr2 = {-2, 3, 2, -1}
Max sum will be result of subarray {3,2} => 5
O/p: 5
 */
public class MaxSubarraySum {

    public static void main(String[] args) {

        int[] arr1 = new int[]{1, -3, 2, 1, -1};
        int[] arr2 = new int[]{-2, 3, 2, -1};

        System.out.println(maxSumSubArr(arr1));
        System.out.println(maxSumSubArr(arr2));

    }

    private static int maxSumSubArr(int[] inpArr) {

        int maxCurrent = inpArr[0];
        int maxGlobal = inpArr[0];

        for(int i=1; i< inpArr.length;i++){
            maxCurrent = Math.max(inpArr[i],maxCurrent+inpArr[i]);
            if(maxCurrent > maxGlobal){
                maxGlobal = maxCurrent;
            }
        }
        return maxGlobal;
    }

}
