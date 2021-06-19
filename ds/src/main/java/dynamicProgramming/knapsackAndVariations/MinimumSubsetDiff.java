package dynamicProgramming.knapsackAndVariations;

/*

Given an array: arr[] divide it in 2 partitions such that
difference of the sum of elements in two partitions is the minimum.

Ex1:
arr[] = {1, 6, 11, 5}
Output : 1

S1 = [1,6,5] => 12
S2 = [11] => 11

Ex2:
arr[] = {3,1,1,2,2,1}
S1 = {1,1,1,2} => 5
S2 = {2,3} => 5


 */
public class MinimumSubsetDiff {


    public static void main(String[] args) {

        int arr[] = new int[]{1,6,11,5};

        int min = Integer.MAX_VALUE;

        int totalSum =0;
        for(int i=0 ; i < arr.length;i++){
            totalSum += arr[i];
        }

        boolean[][] dpMatrix = getMinimumDifference(arr,totalSum);
        int i = dpMatrix.length-1;

        System.out.println("Printing DP matrix =>");

//        for(int i=0 ; i < dpMatrix.length; i++){
//            for(int j=0 ; j <dpMatrix[0].length; j++){
//                System.out.print(dpMatrix[i][j]+" ");
//            }
//            System.out.println();
//        }

        for(int j=0; j <dpMatrix[0].length/2; j++){
            if(dpMatrix[i][j]){
                min = Math.min(min,totalSum-2*j);
            }
        }

        System.out.println("Minimum "+min);

    }

    //Subset sum code
    private static boolean[][] getMinimumDifference(int[] arr, int totalSum) {

        boolean[][] dp = new boolean[arr.length+1][totalSum+1];

        for(int i=0; i < dp.length; i++){
            for(int j=0; j < dp[0].length;j++){
                if(j==0){
                    dp[i][j] = true;
                }
                if(i ==0 && j > 0){
                    dp[i][j] = false;
                }
            }
        }

        for(int i=1; i < dp.length; i++){
            for(int j=1 ; j< dp[0].length; j++){

                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp;

    }
}
