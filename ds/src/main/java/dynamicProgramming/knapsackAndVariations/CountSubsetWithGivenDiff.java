package dynamicProgramming.knapsackAndVariations;

import java.util.Arrays;
import java.util.List;

/*

Given a array of numbers, find out how many two partitions can be created such that there difference
is equal to the given difference.

Ex:

arr = {1, 1, 2, 3}
diff = 1

O/p: 3

Subsets partitions that can result in diff 1 are:
S1 = [1, 2] S2 =[1, 3]
S1 = [3]  S2=[1, 1, 2]
S1 = [1, 2] S2 = [1, 3] => (Since there are 2 1's so each of the 1's will result in 2 subsets.)


https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=13


 */
public class CountSubsetWithGivenDiff {

    public static void main(String[] args) {

        int[] arr = new int[] {1, 1, 2, 3};
        int diff = 1;

        int totalSum = 0;

        for(int i=0 ; i < arr.length; i++){
            totalSum = totalSum+arr[i];
        }

        int targetSum = (totalSum-diff)/2;

        int result = sumSubsetCountUsingDp(arr,targetSum);

        System.out.println("Final result => "+result);
    }

    private static int sumSubsetCountUsingDp(int[] numList, int targetSum) {

        int[][] dp = new int[numList.length+1][targetSum+1];

        for(int i=0; i < dp.length; i++){
            for(int j=0; j < dp[0].length;j++){
                if(j==0){
                    dp[i][j] = 1;
                }
                if(i ==0 && j > 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1; i < dp.length; i++){
            for(int j=1 ; j< dp[0].length; j++){

                if(numList[i-1] <= j){
                    dp[i][j] = dp[i-1][j-numList[i-1]]+dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[numList.length][targetSum];
    }



}
