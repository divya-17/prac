package linkedList.createLinkedList;

public class App {

    public static void main(String[] args) {

        App app = new App();
        app.createLinkedList();



    }

    public Node createEvenLenLinkedList(){

        Node head;

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        head = n1;
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        return head;
    }

    public Node createOddLenLinkedList(){

        Node head;

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        head = n1;
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        return head;
    }

    public Node createNumberLinkedList1(){

        Node head;

        Node n1 = new Node(4);

        head = n1;

        Node n2 = new Node(9);
        Node n3 = new Node(6);
        n1.setNext(n2);
        n2.setNext(n3);

        return head;
    }

    public Node createNumberLinkedList2(){

        Node head;

        Node n1 = new Node(4);

        head = n1;

        Node n2 = new Node(9);
        Node n3 = new Node(9);
        n1.setNext(n2);
        n2.setNext(n3);

        return head;
    }

    public Node createNumberLinkedList3(){

        Node head;

        Node n1 = new Node(9);

        head = n1;

        Node n2 = new Node(9);
        Node n3 = new Node(9);
        n1.setNext(n2);
        n2.setNext(n3);

        return head;
    }

    public Node createDuplicateLinkedList(){

        Node head;

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(2);
        Node n4 = new Node(3);
        Node n5 = new Node(4);

        head = n1;
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        return head;
    }
    public Node createLoopedLinkedList() {

        Node head;

        Node n1 = new Node(1);
        head = n1;
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);
        n8.setNext(n9);
        n9.setNext(n10);
        n10.setNext(n2);

        return head;
    }

    public Node createLinkedList() {

        Node head;

        Node n1 = new Node(1);
        head = n1;
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);
        n8.setNext(n9);
        n9.setNext(n10);

        return head;
    }

}
