package slidingWindow;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*

Given an array of +ve/-ve numbers and a window size k, find the maximum number
in each window of size k.
Ex:
arr: [1, 3, -1, -3, 5, 3, 6, 7]
k = 3

(1, 3, -1) => 3
(3, -1, -3) => 3
(-1, -3, 5) => 5
(-3, 5, 3) => 5
(5, 3, 6) => 6
(3, 6, 7) => 7

O/p: [3, 3, 5, 5, 6, 7]
 */
public class MaxInSubArrayOfSizeK {

    public static void main(String[] args) {


        int arr[] = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        List<Integer> result = new ArrayList<>();

        getMaxInEachWindow(arr, k, result);

        System.out.println(result);
    }

    private static void getMaxInEachWindow(int[] arr, int k, List<Integer> result) {

        Deque<Integer> dequeue = new LinkedList<>();

        int strt = 0;
        int end = 0;

        while (end < arr.length) {

            if(dequeue.isEmpty()){
                dequeue.add(end);
            }
            if (arr[end] > arr[dequeue.peekFirst()]) {
                // if new element that is added in the queue is bigger than all other elements in the queue
                // then all other elems are not required.
                while (!dequeue.isEmpty()) {
                    dequeue.removeFirst();
                }
                dequeue.add(end);
            } else if (arr[end] < arr[dequeue.peekLast()]) {
                dequeue.addLast(end);
            } else if (arr[end] < arr[dequeue.peekFirst()] && arr[end] > arr[dequeue.peekLast()]) {
                while (arr[dequeue.peekLast()] < arr[end]) {
                    dequeue.removeLast();
                }
                dequeue.add(end);
            }

            if (end - strt + 1 == k) {

                result.add(arr[dequeue.peekFirst()]);

                if (dequeue.peekFirst() == strt) {
                    dequeue.removeFirst();
                }
                strt++;
            }

            end++;
        }
    }
}
