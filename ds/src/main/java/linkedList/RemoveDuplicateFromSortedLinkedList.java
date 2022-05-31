package linkedList;

import linkedList.createLinkedList.App;
import linkedList.createLinkedList.Node;

/*
Given a sorted linked list with duplicate data nodes, delete all the duplicate nodes.
https://www.youtube.com/watch?v=dhLtP3UriEU&list=PLDdcY4olLQk0Uh49MmvFUS-56ZfJ79hU9&index=6
 */
public class RemoveDuplicateFromSortedLinkedList {

    public static void main(String[] args) {

        App app = new App();

        Node head = app.createDuplicateLinkedList();

        System.out.println(head);

        deleteDuplicateNode(head);

        System.out.println(head);
    }

    private static void deleteDuplicateNode(Node head) {

        while (head.getNext() != null){

            if(head.getData() == head.getNext().getData()){
                head.setNext(head.getNext().getNext());
            }
            head = head.getNext();

        }
    }
}
