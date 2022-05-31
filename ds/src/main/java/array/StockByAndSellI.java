package array;

/*
https://www.geeksforgeeks.org/stock-buy-sell/
What will be the max profit if we can buy and sell stock only once.
 */
public class StockByAndSellI {

    public static void main(String[] args) {

        int prices [] = new int[] {7,1,5,3,6,4};

        int maxProfit = getMaxProfitFromBuyAndSell(prices);
        System.out.println("Max Profit =>"+maxProfit);
    }

    private static int getMaxProfitFromBuyAndSell(int[] prices) {

        int min = prices[0];
        int max = prices[0];

        int maxProfit = 0;

        for(int i=1; i < prices.length; i++){

            if(prices[i] < min){
                min = prices[i];
                max = prices[i];
            }

            else if(prices[i] > max){
                max = prices[i];
            }

            if((max-min) > maxProfit){
                maxProfit = (max-min);
            }
        }

        return maxProfit;
    }

}

