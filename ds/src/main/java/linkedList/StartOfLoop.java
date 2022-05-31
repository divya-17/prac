package linkedList;

import linkedList.createLinkedList.App;
import linkedList.createLinkedList.Node;

/*
Find the junction of the loop i.e element at which the loop is starting.
 */
public class StartOfLoop {

    public static void main(String[] args) {

        App app = new App();
        Node head = app.createLoopedLinkedList();

        findStartOfTheLoop(head);
    }

    private static void findStartOfTheLoop(Node head) {

        Node low = head;
        Node high = head;
        boolean cycleFound = false;

        while(low != null && high != null && high.getNext() != null){

            low = low.getNext();
            high = high.getNext().getNext();

            if(low == high){
                cycleFound = true;
                break;
            }
        }

        if(cycleFound){
            low = head;

            while (low != high){
                low = low.getNext();
                high = high.getNext();
            }
            System.out.println("Cycle starts at: "+low.getNext().getData());
        }
    }
}

