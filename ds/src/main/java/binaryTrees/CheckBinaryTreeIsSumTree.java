package binaryTrees;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

/*
Given a binary tree, check if it is a sum tree.
Property of a sum tree is that value at each node is equal to the left tree value + right tree value.
 */
public class CheckBinaryTreeIsSumTree {

    private static Boolean result=true;

    public static void main(String[] args) {
        App app = new App();

        Node rootNode1 = app.getSumTree1();
        Node rootNode2 = app.getSumTree();

        checkIfBinaryTree(rootNode1);
        System.out.println(result);

        checkIfBinaryTree(rootNode2);
        System.out.println(result);
    }

    private static int checkIfBinaryTree(Node rootNode) {

        if(rootNode == null) return 0;
        if(rootNode.getLeftNode() == null && rootNode.getRightNode() == null) return rootNode.getData();

        int leftTreeSum = checkIfBinaryTree(rootNode.getLeftNode());
        int rightTreeSum = checkIfBinaryTree(rootNode.getRightNode());

        if(leftTreeSum+rightTreeSum != rootNode.getData()) result = false;

        return rootNode.getData()+leftTreeSum+rightTreeSum;
    }
}
