package dynamicProgramming.knapsackAndVariations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an unsorted array of numbers, print all possible increasing sequence of numbers possible.
 */
public class LongestIncreasingSubSequence {

    private static List<String> allPossibleSequence = new ArrayList<>();
    private static int maxSumValue = Integer.MIN_VALUE;

    public static void main(String[] args) {

        int[] inpArr = new int[]{1, 2, 5, 3, 4};


        getAllPossibleIncreasingSequenceNumbers(inpArr,Integer.MIN_VALUE,"",0);
        System.out.println(allPossibleSequence);
        System.out.println("Max Sum: "+maxSumValue);
    }

    private static void getAllPossibleIncreasingSequenceNumbers(int[] inpArr,int prev, String ans,int currentSum) {

        if(inpArr.length == 0){
            allPossibleSequence.add(ans);
            if(currentSum > maxSumValue){
                maxSumValue = currentSum;
            }
            return;
        }
        if(inpArr[0] > prev) {
            getAllPossibleIncreasingSequenceNumbers(Arrays.copyOfRange(inpArr, 1, inpArr.length), inpArr[0], ans + inpArr[0] + ",",currentSum+inpArr[0]);
        }

        getAllPossibleIncreasingSequenceNumbers(Arrays.copyOfRange(inpArr,1,inpArr.length),prev,ans,currentSum);
    }
}
