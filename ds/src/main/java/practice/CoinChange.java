package practice;

public class CoinChange {


    static int [][] dp = new int[12][(int) Math.pow(10,4)];

    public static void main(String[] args) {

        int[] coins = new int[] {1,2,5};
        int totalAmount = 11;

        for(int i =0; i <= dp.length; i++){
            for(int j =0; j < dp[0].length; j++){
                dp[i][j]=-1;
            }
        }
        int minCoins = coinChangeFunc(coins,totalAmount,coins.length);
        System.out.println(minCoins);

    }

    public static int coinChangeFunc(int [] coins, int amount, int n){

        if(amount == 0) return 0;
        if(n == 0) return Integer.MAX_VALUE-1;

        if(dp[n-1][amount] != -1){
            return dp[n-1][amount];
        }
        if(coins[n-1] <= amount){
            return dp[n-1][amount] = Math.min(1+coinChangeFunc(coins,amount-coins[n-1],n),
                    coinChangeFunc(coins,amount,n-1));
        }
        else{
            return dp[n-1][amount] = coinChangeFunc(coins,amount,n-1);
        }

    }
}
