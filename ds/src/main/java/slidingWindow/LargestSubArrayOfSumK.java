package slidingWindow;


/*
This problem is of type variable length sliding window:

Given an array of numbers and a sum K, find the largest length of the array that will sum up to value k.

Ex:

arr = [4, 1, 1, 1, 2, 3, 5]
sum = 5

Subarrays that will add up to sum 5:

(4, 1) => size: 2
(1, 1, 1, 2) => size: 4
(2, 3) => size: 2
(5) => size: 1
O/p: 4


 */
public class LargestSubArrayOfSumK {


    public static void main(String[] args) {

        int arr[] = new int[] {4, 1, 1, 1, 2, 3, 5};
        int sum = 5;

        int length = lenghtOfLargestSubArrayOfSumK(arr,sum);
        System.out.println(length);

    }

    private static int lenghtOfLargestSubArrayOfSumK(int[] arr, int sum) {

        int maxSize = 0;

        for(int strt =0; strt < arr.length; strt++){

            int currwindowSize = 0;
            int currWindowSum = 0;
            int end = strt;

            while (end < arr.length && currWindowSum < sum){

                currWindowSum = currWindowSum+arr[end];
                currwindowSize++;
                if(currWindowSum == sum){
                    break;
                }
                end++;
            }
            maxSize = Math.max(maxSize,currwindowSize);
        }
        return maxSize;
    }

}
