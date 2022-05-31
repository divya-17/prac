package binaryTrees.Ques.treeViews;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

/*
Check if a binary tree is a symmetrical tree or not.
A Binary tree is a symmetric binary tree if the left sub tree is the mirror image of the right subtree.
 */
public class SymmetricBinaryTree {

    public static void main(String[] args) {


        App app = new App();

        Node rootNode =app.getSymmetricTree();

        Boolean result = isSymmetricalTree(rootNode.getLeftNode(),rootNode.getRightNode());

        System.out.println(result);
    }

    public static  Boolean isSymmetricalTree(Node leftNode, Node rightNode){


        if(leftNode == null && rightNode == null) return true;

        if(leftNode.getData() == rightNode.getData()){
            return isSymmetricalTree(leftNode.getLeftNode(),rightNode.getRightNode()) &&
                    isSymmetricalTree(leftNode.getRightNode(),rightNode.getLeftNode());
        }
        else return false;


    }

}
