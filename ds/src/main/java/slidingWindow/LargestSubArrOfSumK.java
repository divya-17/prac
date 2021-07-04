package slidingWindow;

/*
Given an arr of positive numbers and a sum k, find the largest subarray in that array that will sum up to k.

arr = [4, 1, 1, 1, 2, 3, 5]
k = 5

subArrays:
(4, 1) -> size(2)
(1, 1, 1, 2) -> size(4)
(2, 3)-> size(5)
(5)-> size(5)

max size of subarray: 4
 */
public class LargestSubArrOfSumK {

    public static void main(String[] args) {


        int [] arr = new int[] {4, 1, 1, 1, 2, 3, 5};
        int k = 5;
        int maxLen = getLargestSubArrOfSumK(arr,k);
        System.out.println("Max subarray len is "+maxLen);
    }

    private static int getLargestSubArrOfSumK(int[] arr, int k) {

        int strt =0;
        int end = 0;
        int runningSum =0;
        int maxWindowSize = 0;

        while (end < arr.length){

            runningSum = runningSum+arr[end];

            if(runningSum > k){
                while (strt < end && runningSum > k){
                    runningSum = runningSum -arr[strt];
                    strt++;
                }

            }

            if(runningSum == k){
                maxWindowSize = Math.max(maxWindowSize,(end-strt+1));
            }
            end++;
        }
        return maxWindowSize;
    }


}
