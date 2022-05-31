package dynamicProgramming.knapsackAndVariations;

/*
https://leetcode.com/problems/house-robber/
Given array of numbers that represent money thief will get if he robbed that house, find the
max profit that thief can make given that thief can't rob ajacent houses.

nums = [1,2,3,1]
profit: 4

nums = [2,7,9,3,1]
profit: 12

nums = [1,2,3,1,1,100]
profit 104

 */
public class HouseRobberProblem {

    private static Integer[] dp;

    public static void main(String[] args) {

       // int [] nums = new int[] {1,2,3,1,1,100};

        int[] nums = new int[]{1,2,3,1};

        dp = new Integer[nums.length];

        int maxProfit = robFrom(nums,nums.length-1);

        System.out.println("Max profit "+maxProfit);
    }

    private static int robFrom(int[] nums, int currIndex) {

        if(currIndex < 0 ){
            return 0;
        }

        if(dp[currIndex] != null){
            return dp[currIndex];
        }
        int stealCurrent = nums[currIndex]+robFrom(nums,currIndex-2);
        int skipCurr = robFrom(nums,currIndex-1);

        return dp[currIndex] = Math.max(stealCurrent,skipCurr);

    }
}
