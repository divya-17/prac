package dynamicProgramming.knapsackAndVariations;

/*



 */
public class TargetSum {

    public static void main(String[] args) {

        int [] arr = {1, 1, 2, 3};
        int targetSum = 1 ;

        int numWay =numWaysToGetTargetSum(arr,0,targetSum,arr.length);

        System.out.println(numWay);
    }

    private static int numWaysToGetTargetSum(int[] arr, int initialSum, int targetSum, int length) {

//        System.out.println("");
//        System.out.println("");
//        System.out.println("Entered inside numWays");
//        System.out.println("Initial data is ");
//        System.out.println("Sum till now:" + initialSum);
//        System.out.println("Target Sum:" + targetSum);
//        System.out.println("Lenght array is " + length);
//        if (length > 0) {
//            System.out.println("Element in arrat to be considered now: " + arr[length - 1]);
//        }

//        if (initialSum == targetSum && length == 0){
//            System.out.println("Sum so far is same as target Sum. Returning 1");
//            return 1;
//        }

        if (initialSum != targetSum && length == 0) {
            System.out.println("No element left in array to process. Returning 0");
            return 0;
        }
        //System.out.println("Going to find ways by adding current element in sum so far " + initialSum + " " + arr[length -1]);
        int waysWithAddingCurrent = numWaysToGetTargetSum(arr, initialSum+arr[length-1], targetSum, length-1);
        //System.out.println("Ways by adding  " + arr[length -1] + " plus " + initialSum +  " is " + waysWithAddingCurrent);

        //System.out.println("Going to find ways by subtracting current element in sum so far " + initialSum + " " + arr[length -1]);
        int waysWithSubtractingCurrent = numWaysToGetTargetSum(arr, initialSum-arr[length-1], targetSum, length-1);
        //System.out.println("Ways by subtracting " + initialSum  + " minus " + arr[length -1] +  " is " + waysWithAddingCurrent);

        int sum = waysWithAddingCurrent + waysWithSubtractingCurrent;
        //System.out.println("Total ways to reach targetsum with initial sum " + initialSum + " and current element " + arr[length -1] + " is " + sum);
        return sum;
    }



}
