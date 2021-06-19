package dynamicProgramming.knapsackAndVariations;

/*

Given a set of numbers, determine true/false if the  numbers can be distributed into 2 sets such that
the sum of elements in both sets are equal

Ex:

arr[] = {1, 5, 11, 5}
O/p: true

Array can be partitioned into [1,5,5] and [11]


arr = [1, 5, 3]
O/p: false

Array cannot be partitioned into equal sum sets

 */
public class EqualPartitionSum {

    public static void main(String[] args) {

        int arr1[] = {1, 5, 11, 5};

        boolean exists = false;
        int totalSum = 0 ;

        for(int i=0; i < arr1.length; i++)
            totalSum += arr1[i];

        // If total sum is odd , no 2 partitions is possible with equal sum
        if(totalSum %2 == 0) {

            int targetSum = totalSum / 2;
            exists = subsetSumExist(targetSum, arr1);
        }

        System.out.println("Result => "+exists);
    }

    // Below func is same as that in subset sum problem.
    private static boolean subsetSumExist(int targetSum, int[] arr1) {

        boolean[][] dp = new boolean[arr1.length+1][targetSum+1];

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

                if(arr1[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr1[i-1]] || dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[arr1.length][targetSum];
    }

}
