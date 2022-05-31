package binaryTrees.createTree;

public class BST {

    private Node rootNode;


    public Node insertNode(Node node,int data){

        if(node == null){
            return new Node(data);
        }
        node.setData(data);
        return node;
    }

    public Node insertLeftNode(Node node,int data){

        Node leftNode = insertNode(null,data);
        node.setLeftNode(leftNode);
        return leftNode;

    }
    public Node insertRightNode(Node node, int data){

        Node rightNode = insertNode(null,data);
        node.setRightNode(rightNode);
        return rightNode;
    }

    @Override
    public String toString() {
        return "BST{" +
                "rootNode=" + rootNode +
                '}';
    }
}
