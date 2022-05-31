package linkedList;

import linkedList.createLinkedList.App;
import linkedList.createLinkedList.Node;

public class MiddleElemInLinkedList {

    public static void main(String[] args) {

        App app = new App();
        //Node head = app.createEvenLenLinkedList();
        Node head = app.createOddLenLinkedList();
        Node middleNode = findMiddleElem(head);
        System.out.println(middleNode);
    }

    private static Node findMiddleElem(Node head) {

        Node slowPointer = head;
        Node fastPointer = head;

        while(fastPointer !=null && fastPointer.getNext() != null){

            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
        }
        return slowPointer;
    }
}
