package dynamicProgramming.knapsackAndVariations;

import java.util.*;

/*

Given a set of non-negative integers and a value sum, determine if there is a subset with sum equal to given sum

Ex:

i/p: set[] = {3, 34, 4, 12, 5, 2}
sum = 9

o/p: true
There is a subset (4,5) whose sum is 9

i/p: set[] = {3, 34, 4, 12, 5, 2}
sum=30
o/p: false

There is no subset with sum 30


 */
public class SubsetSum {

    public static void main(String[] args) {

        List<Integer> numList  = new ArrayList<>(Arrays.asList(3, 34, 4, 12, 5, 2));
        int targetSum = 9;

        int targetSum1 = 30;


        Boolean recExists = sumSubsetPresentUsingRecursion(numList,targetSum,numList.size());
        Boolean dpExists = sumSubsetPresentUsingDp(numList,targetSum);

        Boolean recExists1 = sumSubsetPresentUsingRecursion(numList,targetSum1,numList.size());
        Boolean dpExists1 = sumSubsetPresentUsingDp(numList,targetSum1);

        System.out.println("Subset present result thru recursion is "+recExists);
        System.out.println("Subset present result thru dp is "+dpExists);

        System.out.println("Subset present result thru recursion is "+recExists1);
        System.out.println("Subset present result thru dp is "+dpExists1);

    }

    private static Boolean sumSubsetPresentUsingRecursion(List<Integer> numList, int targetSum, int n) {

        if(n==0 && targetSum!= 0){
            return false;
        }
        if(targetSum == 0){
            return true;
        }

        if(numList.get(n-1) <= targetSum){
            return sumSubsetPresentUsingRecursion(numList,targetSum-numList.get(n-1),n-1)
                    || sumSubsetPresentUsingRecursion(numList, targetSum, n-1);
        }
        else {
            return sumSubsetPresentUsingRecursion(numList, targetSum, n-1);
        }
    }


    private static Boolean sumSubsetPresentUsingDp(List<Integer> numList, int targetSum) {

        boolean[][] dp = new boolean[numList.size()+1][targetSum+1];

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

                if(numList.get(i-1) <= j){
                    dp[i][j] = dp[i-1][j-numList.get(i-1)] || dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[numList.size()][targetSum];
    }

}
