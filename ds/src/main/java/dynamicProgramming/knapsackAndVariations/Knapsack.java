package dynamicProgramming.knapsackAndVariations;

/*
0/1 knapsack problem.

Given a weight and value array and knapsack of given weight,
Find the max price that can fit in that knapsack?

Ex:

wt[] = [24, 10, 10, 7]
val[] = [24, 18, 18, 10]

W = 25

O/p: Max Profit: (18+18) = 36



wt[] = [10, 20, 30]
val [] = [60,100, 120]

W = 50

O/p: Max profit(100+120) = 220


 */
public class Knapsack {

    public static void main(String[] args) {

        int wt[] = new int[]{ 24, 10, 10, 7};
        int val[] = new int[]{ 24, 18, 18, 10};
        int capacity = 25;

        int wt1[] = new int[]{10, 20, 30};
        int val1[] = new int[]{60, 100, 120};
        int capacity1 = 50;

        int recMaxProfit1 = knapsack(wt, val, capacity,wt.length);
        int dpMaxProfit1 = dpKnapsack(wt,val,capacity,wt.length);

        int recMaxProfit2 = knapsack(wt1, val1, capacity1, wt1.length);
        int dpMaxProfit2 = dpKnapsack(wt1,val1,capacity1,wt.length);

        System.out.println("Max Profit for case 1 using recursion "+recMaxProfit1);
        System.out.println("Max Profit for case 1 using DP "+dpMaxProfit1);


        System.out.println("Max Profit for case 2 using recursion "+recMaxProfit2);
        System.out.println("Max Profit for case 2 using DP "+dpMaxProfit2);




    }

    private static int dpKnapsack(int[] wt, int[] val, int capacity, int length) {


        int[][] dp = new int [wt.length+1][capacity+1];

        for(int i=0; i < dp.length; i++){
            for(int j=0 ; j < dp[0].length; j++){

                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1; i< dp.length; i++){
            for(int j=1; j<dp[0].length; j++){

                if(wt[i-1] <= j){

                    dp[i][j] = Math.max((val[i-1]+dp[i-1][j-wt[i-1]]), dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[wt.length][capacity];

    }

    private static int knapsack(int[] wt, int[] val, int capacity, int length) {

        if(capacity==0 || length ==0){
            return 0;
        }
        else {
            // Consider item
            if(wt[length-1] <= capacity){

                return Math.max((val[length-1]+knapsack(wt, val, capacity-wt[length-1], length-1)),
                        (knapsack(wt,val,capacity,length-1)));
            }
            // Can't add that item
            else {
                    return knapsack(wt, val, capacity, length-1);
            }
        }
    }
}
