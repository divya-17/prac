package binarySearchTree;

public class BSTApp {



    public void deleteNode(Node rootNode, int value){

        if (rootNode.getNodeValue() == value){
            
        }
    }

    // Create BST
    public Node insert(Node node, int value){

        if(node == null){
            node = createNewNode(value);
            return node;
        }
        if(value < node.getNodeValue()){
            node.setLeftNode(insert(node.getLeftNode(),value));
        }
        else if(value > node.getNodeValue()){
            node.setRightNode(insert(node.getRightNode(),value));
        }
        return node;
    }

    private Node createNewNode(int value) {

        Node node = new Node();
        node.setNodeValue(value);
        node.setLeftNode(null);
        node.setRightNode(null);

        return node;
    }
}
