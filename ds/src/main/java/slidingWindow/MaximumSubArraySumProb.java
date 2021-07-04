package slidingWindow;

/*

Given an array arr and a window size k, find the maximum sum that we can get in any subarray of size k

Ex:

arr = {2, 5, 1, 8, 2, 9, 1}
k = 3

sum(2, 5, 1) => 8
sum(5, 1, 8) =>14
sum(1, 8, 2) => 11
sum(8, 2, 9) => 10
sum(2, 9, 1) => 12

O/p:
max sum: 14

 */
public class MaximumSubArraySumProb {


    public static void main(String[] args) {

        int arr[] = new int[] {2, 5, 1, 8, 2, 9, 1};

        int k = 3;

        int maxSum = getMaxSubarrSum(arr,k);
        System.out.println("Maximum sum is "+maxSum);
    }

    private static int getMaxSubarrSum(int[] arr, int k) {

        int strt =0 ;
        int sum =0;
        int maxSum = 0;
        int end = strt;

        while (end < arr.length){

            sum = sum+arr[end];

            if(end-strt+1 == k){
                if(maxSum < sum){
                    maxSum = sum;
                }
                sum = sum-arr[strt];
                strt++;
            }
            end++;

        }
        return maxSum;
    }

}
