package heaps;

import java.util.ArrayList;
import java.util.List;
/*
Min heap is a binary tree structure that have nodes sorted in ascending order.
Ex: Below in a min heap.

        8
      /   \
     7     5
   /  \   /  \
  3   6   5   2

 */
public class MinHeapImpl {

    private List<Integer> unsortedArray;

    MinHeapImpl(List<Integer> numArr){
        unsortedArray = numArr;
    }
    private void heapify(int limit){

        for(int i=0; i< limit/2; i++){

            int largest = i;

            if ((2*i)+1 < limit && unsortedArray.get(i) < unsortedArray.get(2*i+1)){
                largest = 2*i+1;
            }
            if((2*i+2) < limit && unsortedArray.get(i) < unsortedArray.get(2*i+2)){
                largest = 2*i+2;
            }
            if(largest != i){
                swapIndex(i,largest,unsortedArray);
                heapify(limit);
            }

        }
    }

    private void swapIndex(int firstPos, int secondPos,List<Integer> arr) {
        int tmp;
        tmp = arr.get(firstPos);
        arr.set(firstPos,arr.get(secondPos));
        arr.set(secondPos,tmp);
    }

    public static void main(String[] args) {

        List<Integer> numArr = new ArrayList<>();

        numArr.add(2);
        numArr.add(8);
        numArr.add(1);
        numArr.add(5);
        numArr.add(7);
        numArr.add(9);

        MinHeapImpl impl = new MinHeapImpl(numArr);
        System.out.println("Initial arr => "+numArr);

        int maxLimit = numArr.size();

        while (maxLimit > 0) {
            impl.heapify(maxLimit);
            // swap 1st and last pos.
            impl.swapIndex(0, maxLimit - 1, numArr);
            maxLimit --;
        }

        System.out.println("Final sorted array =>"+numArr);
    }

}

