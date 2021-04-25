package heaps;

import java.util.PriorityQueue;
/*
Priority queue poll elements in the sorted ascending order. Priority queue internally
uses heap.
 */
public class PriorityQueueTest {


    public static void main(String[] args) {

        PriorityQueue queue = new PriorityQueue();

        queue.add(4);
        queue.add(10);
        queue.add(3);
        queue.add(7);
        queue.add(15);
        queue.add(1);


        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
