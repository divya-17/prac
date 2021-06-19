package dynamicProgramming.knapsackAndVariations;

public class UnboundedKnapsack {

    public static void main(String[] args) {


        int wt[] = new int[]{ 24, 10, 10, 7};
        int val[] = new int[]{ 24, 18, 18, 10};
        int capacity = 25;

        int wt1[] = new int[]{10, 20, 30};
        int val1[] = new int[]{60, 100, 120};
        int capacity1 = 50;

        int recMaxProfit1 = knapsack(wt, val, capacity,wt.length);
        System.out.println(recMaxProfit1);

    }

    private static int knapsack(int[] wt, int[] val, int capacity, int length) {

        if(capacity==0 || length ==0){
            return 0;
        }
        else {
            // Consider item
            if(wt[length-1] <= capacity){

                return Math.max((val[length-1]+knapsack(wt, val, capacity-wt[length-1], length)),
                        (knapsack(wt,val,capacity,length-1)));
            }
            // Can't add that item
            else {
                return knapsack(wt, val, capacity, length-1);
            }
        }
    }
}
