package binaryTrees.Ques;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

public class CheckIfTreeIsBalanced {

    private static Boolean isTreeBalanced = true;
    public static void main(String[] args) {


        App app = new App();
        Node rootNode = app.getBSTTree();

        getHeightOfTree(rootNode);

        System.out.println("Answer: "+isTreeBalanced);
    }

    private static int getHeightOfTree(Node rootNode) {

        if(rootNode == null) return 0;

        int h1 = getHeightOfTree(rootNode.getLeftNode());
        int h2 = getHeightOfTree(rootNode.getRightNode());

        if(Math.abs(h1-h2) > 1) isTreeBalanced = false;
        return 1+Math.max(h1,h2);
    }
}
