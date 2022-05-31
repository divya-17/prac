package binaryTrees.Ques;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

/*
Given a binary tree, find distance between two nodes in the binary tree.

 */
public class DistanceBetweenTwoNodes {

    public static void main(String[] args) {
        App app = new App();
        Node rootNode = app.getBSTTree1();

        int srcNode = 9;
        int dstNode = 3;

        int distance = getDistanceBetweenTwoNodes(rootNode,srcNode,dstNode);

        System.out.println("Distance between src: "+srcNode+" and dst: "+dstNode+" is "+distance);
    }

    private static int getDistanceBetweenTwoNodes(Node rootNode, int srcNode, int dstNode) {

//        System.out.println("Source Node: "+srcNode);
//        System.out.println("Destination Node: "+dstNode);
        Node lowestAncestorNode = getLCA(rootNode,srcNode,dstNode);

        System.out.println("Lowest ancestor node: "+lowestAncestorNode.getData());

        int distance1 = getDistanceFromRootNode(lowestAncestorNode,srcNode,0);
      //  System.out.println(distance1);
        int distance2 = getDistanceFromRootNode(lowestAncestorNode,dstNode,0);
       // System.out.println(distance2);
        return distance1+distance2;
    }

    private static int getDistanceFromRootNode(Node rootNode, int targetNode, int dist) {

        if(rootNode == null) return 0;
        if(rootNode.getData() == targetNode) return dist;

        int leftTreeDist = getDistanceFromRootNode(rootNode.getLeftNode(),targetNode,dist+1);
        int rightTreeDist = getDistanceFromRootNode(rootNode.getRightNode(),targetNode,dist+1);

        return leftTreeDist+rightTreeDist;
    }

    private static Node getLCA(Node rootNode, int srcNode, int dstNode) {

        if(rootNode == null) return null;
        if(rootNode.getData() == srcNode || rootNode.getData() == dstNode) return rootNode;

        Node leftLCA = getLCA(rootNode.getLeftNode(),srcNode,dstNode);
        Node rightLCA = getLCA(rootNode.getRightNode(),srcNode,dstNode);

        if(leftLCA == null) return rightLCA;
        if(rightLCA == null) return leftLCA;

        else return rootNode;
    }

}
