package binaryTrees.Ques;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

public class HeightOfTree {

    public static void main(String[] args) {

        App app = new App();
        Node rootNode = app.getBSTTree();

        int height = getHeightOfTree(rootNode);
        System.out.println(height);

    }

    private static int getHeightOfTree(Node rootNode) {

        if(rootNode == null){
            return 0;
        }
        int x = getHeightOfTree(rootNode.getLeftNode());
        int y = getHeightOfTree(rootNode.getRightNode());
        return 1+Math.max(x,y);
    }
}
