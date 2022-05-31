package heaps;

import java.util.PriorityQueue;

/*
Given an array which is k-sorted [elem that will be present at any index afer sort will be present in the unsorted array in range of +- k elems]
Sort the array completely.

Eg: arr:[6, 5, 3, 2, 8, 10, 9]
k = 4;

result: [2, 3, 5, 6, 8, 9, 10]

result[0] was in range arr[0],arr[1],arr[2],arr[3].
result[1] was in range arr[2],arr[3],arr[4] and so on.

 */
public class sortKSortedArray {

    private static int[] inputArr = new int[7];
    private static int[] sortedArr = new int[7];
    private static int k =4;
    private static PriorityQueue<Integer> heapQueue = new PriorityQueue<>();

    public static void main(String[] args) {

        initializeArray();

        int index = 0;

        for(int i =0 ; i < inputArr.length; i++) {

            heapQueue.add(inputArr[i]);

            if (heapQueue.size() == k) {
                // Min elem at the top of the min heap.
                sortedArr[index] = heapQueue.poll();
                index++;
            }
        }

        while (!heapQueue.isEmpty()){
            sortedArr[index] = heapQueue.poll();
            index++;
        }

        System.out.println("Sorted array is ");
        for (int j =0; j < sortedArr.length; j++){
            System.out.print(sortedArr[j]+" , ");
        }
    }

    private static void initializeArray() {
        inputArr[0]=6;
        inputArr[1]=5;
        inputArr[2]=3;
        inputArr[3]=2;
        inputArr[4]=8;
        inputArr[5]=10;
        inputArr[6]=9;
    }
}
