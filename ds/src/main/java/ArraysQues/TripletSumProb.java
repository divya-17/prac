//package ArraysQues;
//
//import java.util.List;
//
///*
//
//Given an array of integers, Write a code to find all unique triplets in the array.
//
//Input: arr = [1, 2, -3, 4, -2, -1]
//
//Given sum = 1
//
//All possible triplets
//(a) [-1, 4, 2]
//(b) [1, 2, -2]
//
//On the same approach that we took for PairSumProb.
//
//https://www.youtube.com/watch?v=pfVZsffsCYk
//
//
//Complexity expected: O(n2) -> for every elem in the array, pair sum approach will be applied for all other elems
// */
//public class TripletSumProb {
//
//
//    public static void main(String[] args) {
//
//
//        int [] arr = {1, 2, -3, 4, -2, 1};
//        int targetSum = 1;
//
//        List<List<Integer>> finalList = getAllTriplets(arr,targetSum);
//
//    }
//
//    private static List<List<Integer>> getAllTriplets(int[] arr, int targetSum) {
//
//        arr = sortedArray(arr);
//    }
//
//    // Apply binary search to sort the array first.
//
//    private static int[] sortedArray(int[] arr) {
//    }
//
//}
