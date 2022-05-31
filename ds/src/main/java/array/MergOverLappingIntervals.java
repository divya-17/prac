package array;

import javafx.util.Pair;

import java.util.*;

/*
https://leetcode.com/problems/merge-intervals/submissions/
 */
public class MergOverLappingIntervals {

    public static void main(String[] args) {

        /*
        new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}}
         */
        List<Pair<Integer,Integer>> intervals = new ArrayList<>();

        intervals.add(new Pair<>(2,3));
        intervals.add(new Pair<>(4,5));
        intervals.add(new Pair<>(6,7));
        intervals.add(new Pair<>(8,9));
        intervals.add(new Pair<>(1,10));

        Collections.sort(intervals, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });


       mergeOverlappingInterval(intervals);
    }

    private static void mergeOverlappingInterval(List<Pair<Integer, Integer>> intervals) {

        Stack<Pair<Integer,Integer>> intervalStack = new Stack<>();


        for(Pair<Integer,Integer> pair: intervals){

            if(intervalStack.isEmpty()){
                intervalStack.push(pair);
            }
            else{
                Pair<Integer,Integer> mostRecentPair = intervalStack.peek();
                if(pair.getKey() <= mostRecentPair.getValue()){
                    intervalStack.pop();
                    Pair<Integer,Integer> mergedPair = new Pair<>(Math.min(pair.getKey(),mostRecentPair.getKey()),
                            Math.max(pair.getValue(),mostRecentPair.getValue()));
                    intervalStack.push(mergedPair);
                }
                else{
                    intervalStack.push(pair);
                }
            }
        }
        System.out.println("Interval stack is "+intervalStack);

    }
}
