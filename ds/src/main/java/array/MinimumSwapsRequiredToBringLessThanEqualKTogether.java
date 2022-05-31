package array;
/*
https://www.geeksforgeeks.org/minimum-swaps-required-bring-elements-less-equal-k-together/
 */
public class MinimumSwapsRequiredToBringLessThanEqualKTogether {

    public static void main(String[] args) {

        int[] inputArr = new int[] {2, 7, 9, 5, 8, 7, 4};
        int k = 5;
        int result = getMinNumSwaps(inputArr,k);
        System.out.println("Min swaps required "+result);
    }

    private static int getMinNumSwaps(int[] inputArr, int k) {

        int si = 0;
        int ei = inputArr.length-1;
        int totalSwaps = 0;

        while (si < ei){

            if(inputArr[si] <= k){
                si++;
            }
            else if(inputArr[si] > k){
                while (ei > si && inputArr[ei] > k){
                    ei --;
                }
                if(si == ei){
                    return totalSwaps;
                }
                else{
                    swap(inputArr,si,ei);
                    totalSwaps++;
                    si++;
                    ei--;
                }
            }
        }
        return totalSwaps;
    }
    private static void swap(int[] inputArr, int startIndex, int endIndex){

        int temp = inputArr[startIndex];
        inputArr[startIndex] = inputArr[endIndex];
        inputArr[endIndex] = temp;
    }
}
