package dynamicProgramming.knapsackAndVariations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

This problem is similar to subset sum present. In this problem we also need to count
the number of subset sum present in the array.
 */
public class CountSubsetSum {


    public static void main(String[] args) {

        List<Integer> numList  = new ArrayList<>(Arrays.asList(3, 34, 4, 12, 5, 2));
        int targetSum = 9;

        List<Integer> numList1 = new ArrayList<>(Arrays.asList(2, 3, 5, 6, 8, 10));
        int target1 = 10;

        //int targetSum1 = 30;
        int recCount = sumSubsetCountUsingRecursion(numList1,target1,numList1.size());
        int dpCount = sumSubsetCountUsingDp(numList1,target1,numList1.size());

        System.out.println(recCount);
        System.out.println(dpCount);


    }

    private static int sumSubsetCountUsingDp(List<Integer> numList,int targetSum,int n) {

        int[][] dp = new int[numList.size()+1][targetSum+1];

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

                if(numList.get(i-1) <= j){
                    dp[i][j] = dp[i-1][j-numList.get(i-1)]+dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[numList.size()][targetSum];
    }

    private static int sumSubsetCountUsingRecursion(List<Integer> numList, int targetSum, int n) {

        if(n==0 && targetSum!= 0){
            return 0;
        }
        if(targetSum == 0){
            return 1;
        }

        if(numList.get(n-1) <= targetSum){
            return (sumSubsetCountUsingRecursion(numList,targetSum-numList.get(n-1),n-1)+
            sumSubsetCountUsingRecursion(numList, targetSum, n-1));
        }
        else {
            return sumSubsetCountUsingRecursion(numList, targetSum, n-1);
        }

    }



}
