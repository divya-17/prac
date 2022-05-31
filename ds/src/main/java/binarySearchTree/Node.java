package binarySearchTree;

public class Node {

    int nodeValue;
    Node leftNode;
    Node rightNode;


    public Node(int nodeValue, Node leftNode, Node rightNode) {
        this.nodeValue = nodeValue;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Node() {
    }

    public int getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeValue=" + nodeValue +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}
