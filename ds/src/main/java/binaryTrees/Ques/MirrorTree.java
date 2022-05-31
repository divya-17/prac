package binaryTrees.Ques;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

/*
https://practice.geeksforgeeks.org/problems/mirror-tree/1
 */
public class MirrorTree {

    public static void main(String[] args) {

        App app = new App();
        Node rootNode = app.getBSTTree();
        System.out.println("Current Tree "+rootNode);

        getTreeMirrorImage(rootNode);
        System.out.println("Mirror Tree "+rootNode);
    }

    private static void getTreeMirrorImage(Node rootNode) {

        if(rootNode == null){
            return;
        }

        Node leftNode = rootNode.getLeftNode();
        Node rightNode = rootNode.getRightNode();

        getTreeMirrorImage(leftNode);
        getTreeMirrorImage(rightNode);

        rootNode.setRightNode(leftNode);
        rootNode.setLeftNode(rightNode);
    }
}
