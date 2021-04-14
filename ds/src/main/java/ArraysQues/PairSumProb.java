package ArraysQues;

import javafx.util.Pair;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

/*

Two Sum Problem.

Given an array of integers, return indicies of two numbers such that they addup to a target sum.You can't use the same
element twice and there are no duplicates.

Ex:
Given nums = [2, 7, 11, 15]
target sum = 18

Sol: pair (7,11)


 */
public class PairSumProb {


    public static void main(String[] args) {


        int[] arr = {2, 7, 11, 15};
        int targetSum = 18;

        List<Pair<Integer,Integer>> pair = getPairForGivenSum(arr,targetSum);

        System.out.println("List of pair is "+pair);
    }


    private static List<Pair<Integer,Integer>> getPairForGivenSum(int[] arr, int targetSum) {

        int startPointer = 0;
        int endPointer = arr.length-1;
        List<Pair<Integer,Integer>> finalPairList = new ArrayList<>();

        while (startPointer < endPointer){

            int currSum = (arr[startPointer]+arr[endPointer]);
            if(currSum > targetSum ){

                endPointer--;
            }
            else if(currSum < targetSum){

                startPointer ++;
            }
            else {

                finalPairList.add(new Pair<>(arr[startPointer],arr[endPointer]));
                startPointer++;
                endPointer--;
            }
        }

        return finalPairList;

    }
}
