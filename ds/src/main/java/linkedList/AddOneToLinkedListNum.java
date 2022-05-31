package linkedList;

import linkedList.createLinkedList.App;
import linkedList.createLinkedList.Node;

/*
Given a linked list of numbers, add 1 to that number and output result as a linked list.

 */
public class AddOneToLinkedListNum {


    public static void main(String[] args) {

        App app = new App();
        Node head = app.createNumberLinkedList1();

        //Node head = app.createNumberLinkedList2();

       // Node head = app.createNumberLinkedList3();

        System.out.println("Actual linked list => "+head);

        Node reverseHead = reverseLinkedList(head);
       // System.out.println("Reverse linked list "+reverseHead);
        Node newHead = addOneToLinkedList(reverseHead);
        Node currHead = reverseLinkedList(newHead);

        System.out.println("Actual linked list +1 => "+currHead);

        System.out.println(currHead);
    }

    private static Node addOneToLinkedList(Node reverseHead) {

        Node currNode = reverseHead;
        Node nextNode = currNode.getNext();

        while (nextNode != null){

            if(currNode.getData() != 9){
                currNode.setData(currNode.getData()+1);
                return reverseHead;
            }
            else if(currNode.getData() == 9){

                currNode.setData(0);
            }
            currNode = currNode.getNext();
            nextNode = currNode.getNext();

        }
        if(currNode.getData() == 9){
            currNode.setData(0);
            Node newNode = new Node(1);
            currNode.setNext(newNode);
        }
        else{
            currNode.setData(currNode.getData()+1);

        }
        return reverseHead;
    }

    public static Node reverseLinkedList(Node head){


        Node prev = null;
        Node curr = head;

        while (curr != null){

            Node next = curr.getNext();

            curr.setNext(prev);

            prev = curr;
            curr = next;

        }
        return prev;
    }
}
