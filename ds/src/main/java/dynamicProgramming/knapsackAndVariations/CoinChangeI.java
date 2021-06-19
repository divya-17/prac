package dynamicProgramming.knapsackAndVariations;

/*
Variation of Unbounded knapsack:

Given list of coins and a sum, find number of ways in which we can get required sum from the coins.
Supply of each coin is unlimited:

Ex:
coins = [1, 2, 3]
sum: 5
O/p: 5

Num of ways:
[2, 3]
[1, 2, 2]
[1, 1, 3]
[1, 1, 1, 1, 1]
[1, 1, 1, 2]

 */
public class CoinChangeI {

    public static void main(String[] args) {

        int arr[] = new int[]{1, 2, 3};
        int sum = 5;
        int result = numWaysToGetSumUsingRec(arr,sum,arr.length);
        System.out.println(result);

    }

    private static int numWaysToGetSumUsingRec(int[] arr, int sum, int n) {

        if(sum == 0){
            return 1;
        }
        if(sum < 0 || n==0 ){
            return 0;
        }
        return  numWaysToGetSumUsingRec(arr, sum-arr[n-1], n)
                +
                numWaysToGetSumUsingRec(arr, sum, n-1);
    }


}
