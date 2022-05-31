package heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*

Given ropes of different length, what will be the min cost in which all of them can be connected.
Cost of connecting two ropes is equal to sum of their lengths.

Cost of attaching rope len a and rope len b will be => (a+b).

 */
public class ConnectRopesToMinCost {

    private static List<Integer> ropeLenthArr = new ArrayList<>();
    private static Integer totalCost = 0;

    public static void main(String[] args) {


        initializeRopeLenArr();

        Queue<Integer> minHeap = new PriorityQueue();

        for(Integer elem: ropeLenthArr){
            minHeap.add(elem);
        }

        while (minHeap.size() >=2){

            Integer firstShortest = minHeap.poll();
            Integer secondShortest = minHeap.poll();

            Integer connectedLenRope = firstShortest + secondShortest;
            totalCost = totalCost + connectedLenRope;

            minHeap.add(connectedLenRope);

        }

        System.out.println("Min cost for connecting ropes are "+totalCost);
    }

    private static void initializeRopeLenArr() {

        ropeLenthArr.add(8);
        ropeLenthArr.add(4);
        ropeLenthArr.add(6);
        ropeLenthArr.add(12);
    }

}
