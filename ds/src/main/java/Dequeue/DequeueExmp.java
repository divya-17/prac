package Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeueExmp {

    public static void main(String[] args) {


        Deque<String> deque = new ArrayDeque<>();


        deque.add("For");
        deque.add("Geeky");
        deque.add("Geeks");
        deque.add("Guys");


        System.out.println(deque);

        System.out.println(deque.peekFirst()); // Return elem at the start (without removing)
        System.out.println(deque.peekLast()); // Return elem at the end (without remving)
        System.out.println(deque.pop()); // Remove element from start of the queue.

        System.out.println(deque);

        System.out.println(deque.poll()); // Remove element from start of the queue

        System.out.println(deque);

        System.out.println(deque.pollLast());

        System.out.println(deque); // Remove element from the last of the dequeue.
    }


}
