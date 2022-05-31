package heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/*
Given an array, find kth min element in the array

 To find kth smallest elem-> use max heap
 To find kth largest elem -> use min heap
 */
public class MinKthElem {

    public static void main(String[] args) {

        int [] arr = new int[6];
        initializeArr(arr);
        int k = 3;

        // By default java priority queue gives min heap. so for max heap we need to use Collections.reverseOrder
        PriorityQueue queue = new PriorityQueue(Collections.reverseOrder());

        for(int i =0; i <arr.length; i++){
            queue.add(arr[i]);
            if(queue.size() > k){
                queue.poll();
            }
        }
        // Get the top most elem of the queue.
        System.out.println("Final ans "+queue.peek());
    }

    private static void initializeArr(int[] arr) {

        arr[0] = 2;
        arr[1] = 8;
        arr[2] = 1;
        arr[3] = 5;
        arr[4] = 7;
        arr[5] = 9;
    }
}
