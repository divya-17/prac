package linkedList;

import linkedList.createLinkedList.App;
import linkedList.createLinkedList.Node;

/*
Time Complexity O(n)
Space Complexity O(1)
https://www.youtube.com/watch?v=C_bc2tfyM0M&list=PLDdcY4olLQk0Uh49MmvFUS-56ZfJ79hU9&index=3
 */

public class DetectLoopInLinkedList {

    public static void main(String[] args) {


        App app = new App();
       // Node head = app.createLoopedLinkedList();

        Node head = app.createLinkedList();
        boolean ans = cycleExistInLinkedList(head);
        System.out.println(ans);
    }

    private static boolean cycleExistInLinkedList(Node head) {

        if(head == null || head.getNext() == null) return false;

        Node low = head;
        Node high = head;

        while (high != null && high.getNext() != null){

           low = low.getNext();
           high = high.getNext().getNext();

           if(low == high){
               return true;
           }
        }
        return false;
    }
}
