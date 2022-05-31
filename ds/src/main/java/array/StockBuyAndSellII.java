package array;

/*
Given a array where each number in the array denotes price of the share at that day.
If we can buy and sell stocks any number of times, what will be the maximum profit that we can get
 */
public class StockBuyAndSellII {

    public static void main(String[] args) {

        int[] inputArr = new int[] {5, 2, 6, 1, 4, 7, 3, 6};

        int maxProfit = getMaximumProfit(inputArr);

        System.out.println("Max profit :"+maxProfit);

    }

    private static int getMaximumProfit(int[] inputArr) {

        int maxProfit = 0;
        for(int i =1; i < inputArr.length; i++){

            if(inputArr[i] > inputArr[i-1]){
                maxProfit = maxProfit+(inputArr[i]-inputArr[i-1]);
            }
        }
        return maxProfit;
    }


}
