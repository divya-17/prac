package linkedList;

import linkedList.createLinkedList.App;
import linkedList.createLinkedList.Node;

public class ReverseLinkedList {

    public static void main(String[] args) {

        App app = new App();
        Node head = app.createLinkedList();

        Node reverseListHead = reverseLinkedList(head);
        System.out.println(reverseListHead);
    }

    private static Node reverseLinkedList(Node head) {



        // Single element
        if(head.getNext() == null){
            return head;
        }

        // Two elements
        else if(head.getNext().getNext() == null){
                head.getNext().setNext(head);
                return head;
        }
        else{

            Node previousNode = null;
            Node currentNode = head;

            while (currentNode != null){
                Node tempNode = currentNode.getNext();
                currentNode.setNext(previousNode);
                previousNode = currentNode;
                currentNode = tempNode;
            }
            return previousNode;
        }


    }

}
