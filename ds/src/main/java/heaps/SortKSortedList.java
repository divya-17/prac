package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
Given k sorted list of different lengths, merge them into a single list such that final list is also sorted/
 */
public class SortKSortedList {

    private static List<Integer> finalList = new ArrayList<>();

    public static void main(String[] args) {


        List<Integer> l1 = new ArrayList(Arrays.asList(2, 4, 7, 9, 11));
        List<Integer> l2 = new ArrayList(Arrays.asList(3, 4, 5, 10));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(1, 3, 6, 14));

        mergeSort(l1, l2, l3);

        System.out.println("Final sorted list is " + finalList);
    }

    private static void mergeSort(List<Integer> l1, List<Integer> l2, List<Integer> l3) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int l1Index = 0;
        int l2Index = 0;
        int l3Index = 0;

        minHeap.add(l1.get(l1Index));
        minHeap.add(l2.get(l2Index));
        minHeap.add(l3.get(l3Index));

        boolean l1Done = false;
        boolean l2Done = false;
        boolean l3Done = false;

        while (!l1Done||!l2Done||!l3Done) {

            int elem = minHeap.poll();

            if (elem == l1.get(l1Index)) {
                if(l1Index < l1.size()-1) {
                    l1Index++;
                    minHeap.add(l1.get(l1Index));
                }
                else{
                    l1Done = true;
                }
            }
            else if (elem == l2.get(l2Index)) {
                if(l2Index < l2.size()-1) {
                    l2Index++;
                    minHeap.add(l2.get(l2Index));
                }
                else{
                    l2Done = true;
                }
            } else if (elem == l3.get(l3Index)) {
                if(l3Index < l3.size()-1) {
                    l3Index++;
                    minHeap.add(l3.get(l3Index));
                }else{
                    l3Done = true;
                }
            }
            finalList.add(elem);

        }
    }
}
