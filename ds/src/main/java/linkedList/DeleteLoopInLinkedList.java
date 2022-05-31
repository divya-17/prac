package linkedList;

import linkedList.createLinkedList.App;
import linkedList.createLinkedList.Node;

/*
https://www.youtube.com/watch?v=aIR0s1tY2Vk&list=PLDdcY4olLQk0Uh49MmvFUS-56ZfJ79hU9&index=4

Approach using hash map has time complexity of  O(n) and space complexity of O(n).

Below approach has time complexity of O(n) but space complexity of O(1).
 */
public class DeleteLoopInLinkedList {

    public static void main(String[] args) {

        App app = new App();
        Node head = app.createLoopedLinkedList();

        deleteLoopInLinkedList(head);

        System.out.println(head);

    }

    private static void deleteLoopInLinkedList(Node head) {


        Node low = head;
        Node high =head;
        boolean cycleFound = false;

        while(low != null  && high != null  && high.getNext() != null){

            low = low.getNext();
            high = high.getNext().getNext();

            if(low == high) {
                cycleFound = true;
                break;
            }
        }

        if(cycleFound){

            low = head;

            while (low.getNext() != high.getNext()){
                low = low.getNext();
                high = high.getNext();
            }

            high.setNext(null);
        }
    }

}
