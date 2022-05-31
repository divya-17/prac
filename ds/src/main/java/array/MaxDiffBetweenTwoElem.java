package array;
/*
https://www.geeksforgeeks.org/maximum-difference-between-two-elements/

Find maximum difference between two elements such that larger element appears after the smaller number
 */
public class MaxDiffBetweenTwoElem {

    public static void main(String[] args) {

        //int[] arr = new int[] {2, 3, 10, 6, 4, 8, 1};
        int[] arr1 = new int[] {7, 9, 5, 6, 3, 2};
        int maxDiff = getMaxDiff(arr1);

        System.out.println(maxDiff);

    }

    private static int getMaxDiff(int[] arr) {

        int minElem = arr[0];
        int maxDiff = 0;

        for(int i =0; i < arr.length; i++){

            if(arr[i] < minElem){
                minElem = arr[i];
            }
            if(arr[i] - minElem > maxDiff){
                maxDiff = arr[i]-minElem;
            }
        }
        return maxDiff;
    }
}
