package recursion;

public class HeightOfBinaryTree {

    public static void main(String[] args) {

        // Create Graph

        Node rootNode = new Node(1);

        Node leftNode1 = new Node(2);
        Node leftNode2 = new Node(4);
        Node leftNode3 = new Node(6);

        Node rightNode1 = new Node(5);
        Node rightNode2 = new Node(3);
        Node rightNode3 = new Node(7);
        Node rightNode4 = new Node(8);


        rootNode.setLeftNode(leftNode1);
        rootNode.setRightNode(rightNode2);

        leftNode1.setLeftNode(leftNode2);
        leftNode1.setRightNode(rightNode1);

        rightNode2.setLeftNode(leftNode3);
        rightNode2.setRightNode(rightNode3);

        rightNode3.setRightNode(rightNode4);

        int height = getTreeHeight(rootNode,0);

        System.out.println(height+1);
    }

    private static int getTreeHeight(Node currNode,int depth) {

        if(currNode.getLeftNode() == null && currNode.getRightNode() == null){
            return depth;
        }

        if(currNode.getLeftNode() == null && currNode.getRightNode() != null){
            return getTreeHeight(currNode.getRightNode(), depth+1);
        }

        if(currNode.getRightNode() == null && currNode.getLeftNode() != null){
            return getTreeHeight(currNode.getLeftNode(), depth+1);
        }
        else{

            return Math.max( getTreeHeight(currNode.getLeftNode(), depth+1),getTreeHeight(currNode.getRightNode(), depth+1));
        }

    }
}


class Node{

    private int value;
    private Node leftNode;
    private Node rightNode;

    public Node(int value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
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
}