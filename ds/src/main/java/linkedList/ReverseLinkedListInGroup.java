package linkedList;

import linkedList.createLinkedList.App;
import linkedList.createLinkedList.Node;

/*
https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 */
public class ReverseLinkedListInGroup {


    public static void main(String[] args) {

        App app = new App();

        Node headNode = app.createLinkedList();
        int grpSize = 3;
        printList(headNode);

        Node newHeadNode = reverseInGrpSize(headNode,grpSize);
        printList(newHeadNode);
    }

    private static Node reverseInGrpSize(Node head, int k) {

        if(head == null)
            return null;
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;


        while (count < k && current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            count++;
        }
        if (next != null)
            head.setNext(reverseInGrpSize(next,k));

        // prev is now head of input list
        return prev;
    }

    static void printList(Node head)
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }
}
