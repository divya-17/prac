package binaryTrees.Ques;


import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

public class BinaryTreeToSumTree {

    public static void main(String[] args) {

        App app = new App();
        Node rootNode = app.getSumTree();

        System.out.println(rootNode);
        convertBinaryTreeToSumTree(rootNode);
        System.out.println(rootNode);
    }

    private static int convertBinaryTreeToSumTree(Node rootNode) {

        if(rootNode == null) return 0;

        int leftSubTreeSum = convertBinaryTreeToSumTree(rootNode.getLeftNode());
        int rightSubTreeSum = convertBinaryTreeToSumTree(rootNode.getRightNode());

        int currData = rootNode.getData();
        rootNode.setData(leftSubTreeSum+rightSubTreeSum);

        return currData+leftSubTreeSum+rightSubTreeSum;
    }
}
