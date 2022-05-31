package binaryTrees.Ques;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

public class ConvertBinaryTreeIntoLinkedList {

    private static Node currNode = null;
    private static Node headNode = null;

    public static void main(String[] args) {

        App app = new App();
        Node rootNode = app.getLinkedListTree();

        printInOrderTraversal(rootNode);

        flattenBinaryTree(rootNode);
    }

    private static void flattenBinaryTree(Node rootNode) {

        if(rootNode == null) return;

        flattenBinaryTree(rootNode.getLeftNode());
        if(currNode == null){
            headNode = rootNode;
        }else{
            rootNode.setLeftNode(currNode);
            currNode.setRightNode(rootNode);
        }
        currNode = rootNode;
        flattenBinaryTree(rootNode.getRightNode());
    }

    private static void printInOrderTraversal(Node rootNode) {

        if(rootNode == null) return;

        printInOrderTraversal(rootNode.getLeftNode());

        System.out.print(rootNode.getData()+" ");

        printInOrderTraversal(rootNode.getRightNode());

    }
}
