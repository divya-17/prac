package binaryTrees.Ques;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

import java.util.LinkedList;
import java.util.Queue;

/*
CORRECT THIS:
 */
public class DiameterOfTree {

    private static int maxDiameter = 0;

    public static void main(String[] args) {

        App app = new App();
        Node rootNode = app.getBSTTree();

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(rootNode);

        maxDiameter = getDiameterOfTree(rootNode);

        System.out.println(maxDiameter);
    }

    private static int getDiameterOfTree(Node rootNode) {

        if(rootNode == null) return 0;

        int leftDiameter = getDiameterOfTree(rootNode.getLeftNode());
        int rightDiameter = getDiameterOfTree(rootNode.getRightNode());

        int currNodeDiameter = 1 + height(rootNode.getLeftNode())+height(rootNode.getRightNode());

//        System.out.println("Node "+rootNode.getData());
//        System.out.println("Left Diameter "+leftDiameter);
//        System.out.println("Right Diameter "+rightDiameter);
//        System.out.println("Curr Node Diameter "+currNodeDiameter);
        return Math.max(currNodeDiameter,Math.max(leftDiameter,rightDiameter));
    }

    public static int height(Node rootNode){

        if(rootNode == null) return 0;

        return 1+Math.max(height(rootNode.getLeftNode()),height(rootNode.getRightNode()));
    }
}
