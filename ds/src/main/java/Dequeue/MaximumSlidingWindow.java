package Dequeue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*

Ques: Max of all subarrays of size k.

Ex:
Input Arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
k=4;

subArr1 = {8, 5, 10, 7} => max = 10
subArr2 = {5, 10, 7, 9} => max = 10
subArr3 = {10, 7, 9, 4} => max = 10
subArr4 = {7, 9, 4, 15} => max = 15
subArr5 = {9, 4, 15, 12} => max = 15
subArr6 = {4, 15, 12, 90} => max=90
subArr7 = {15, 12, 90, 13} => max = 90

Output Arr = {10, 10, 10, 15, 90, 90}

Explaination video: https://www.youtube.com/watch?v=m-Dqu7csdJk

 */
public class MaximumSlidingWindow {


    public static void main(String[] args) {


        int[] inputArr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};

        int windowSize = 3;

        List<Integer> outArr = getMaxInSubArrayOutput(inputArr,windowSize);

        System.out.println("Output array is: ");

        System.out.println(outArr);
    }

    private static List<Integer> getMaxInSubArrayOutput(int[] inputArr, int windowSize) {


        List<Integer> outputArrList = new ArrayList<>();

        Deque<Integer> deque = new ArrayDeque<>();
        int n = inputArr.length;


        // Process first window size elements first
        int maxIndex = 0;

        for(int i=0; i < windowSize; i++){

            // Find index of max element of first window size elemens
            if(inputArr[i] > inputArr[maxIndex]){
                maxIndex = i;
            }
        }
        // Push max Index of first window in dequeue
        deque.add(maxIndex);

        outputArrList.add(inputArr[maxIndex]);

        // Process rest of the elements
        for(int i =windowSize ; i < n; i++){

            while (!deque.isEmpty())
            {
                if(inputArr[deque.peekLast()] > inputArr[i]){
                    break;
                }
                else{
                    deque.pollLast();
                }
            }
            deque.add(i);

            if(!((i - deque.peekFirst()) < windowSize)){
                deque.pollFirst();
            }

            outputArrList.add(inputArr[deque.peekFirst()]);
        }

        return outputArrList;
    }

}
