package binaryTrees.Ques;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

public class LowestCommonAncestor {

    public static void main(String[] args) {

        App app = new App();
        Node rootNode = app.getBSTTree1();

        Node lcaNode = getLCA(rootNode,8,9);
        System.out.println("LCA Node "+lcaNode);

    }

    private static Node getLCA(Node rootNode, int n1, int n2) {

        if(rootNode == null) return null;

        if(rootNode.getData() == n1 || rootNode.getData() == n2) return rootNode;

        Node leftLca = getLCA(rootNode.getLeftNode(),n1,n2);
        Node rightLca = getLCA(rootNode.getRightNode(),n1,n2);

        if(leftLca == null) return rightLca;
        if(rightLca == null) return leftLca;
        else return rootNode;
    }

}
