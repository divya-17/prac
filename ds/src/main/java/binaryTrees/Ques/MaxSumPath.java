package binaryTrees.Ques;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

/*
Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.
 */
public class MaxSumPath {

    private static int maxSum = Integer.MIN_VALUE;
    private static int res = Integer.MIN_VALUE;

    public static void main(String[] args) {

        App app = new App();
        Node rootNode = app.getMaxSumPathTree();
        getMaxSumPath(rootNode);

        System.out.println("Max sum path is "+maxSum);
    }

    private static int getMaxSumPath(Node rootNode) {

        if(rootNode == null) return 0;

        int leftTreeMaxSum = getMaxSumPath(rootNode.getLeftNode());
        int rightTreeMaxSum = getMaxSumPath(rootNode.getRightNode());

        int tempValue = Math.max(rootNode.getData(),rootNode.getData()+Math.max(leftTreeMaxSum,rightTreeMaxSum));

        maxSum = Math.max(maxSum,Math.max(tempValue,rootNode.getData()+leftTreeMaxSum+rightTreeMaxSum));

        return tempValue;
    }

}
