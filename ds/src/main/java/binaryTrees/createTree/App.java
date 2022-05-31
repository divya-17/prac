package binaryTrees.createTree;

import java.util.HashMap;
import java.util.Map;

public class App {


    public Node getIsomorphicTree1(){

        BST binaryTree = new BST();

        Node rootNode = binaryTree.insertNode(null,1);

        Node leftNode = binaryTree.insertLeftNode(rootNode,2);
        Node rightNode = binaryTree.insertRightNode(rootNode,3);

        Node leftNode1= binaryTree.insertLeftNode(leftNode,4);
        Node rightNode1= binaryTree.insertRightNode(leftNode,5);

        Node leftNode2 = binaryTree.insertLeftNode(rightNode1,7);
        Node rightNode3 = binaryTree.insertRightNode(rightNode1,8);

        Node rightNode4 = binaryTree.insertLeftNode(rightNode,6);

        return rootNode;
    }

    public Node getDuplicateSubTreeNode(){

        BST bst = new BST();

        Node rootNode = bst.insertNode(null,1);

        Node leftNode = bst.insertLeftNode(rootNode,2);
        Node rightNode = bst.insertRightNode(rootNode,3);

        Node leftNode1 = bst.insertLeftNode(leftNode,4);
        Node rightNode1 = bst.insertRightNode(leftNode,5);

        Node rightNode2 = bst.insertRightNode(rightNode,2);

        Node leftNode2 = bst.insertLeftNode(rightNode2,4);
        Node rightNode3= bst.insertRightNode(rightNode2,5);

        return rootNode;
    }
    public Node getIsomorphicTree2(){

        BST binaryTree = new BST();

        Node rootNode = binaryTree.insertNode(null,1);

        Node leftNode = binaryTree.insertLeftNode(rootNode,3);
        Node rightNode = binaryTree.insertRightNode(rootNode,2);

        Node leftNode1= binaryTree.insertLeftNode(rightNode,4);
        Node rightNode1= binaryTree.insertRightNode(rightNode,5);

        Node leftNode2 = binaryTree.insertLeftNode(rightNode1,8);
        Node rightNode3 = binaryTree.insertRightNode(rightNode1,7);

        Node rightNode4 = binaryTree.insertRightNode(leftNode,6);

        return rootNode;
    }

    public Node getMaxSumPathTree(){

        BST bstTree = new BST();

        Node rootNode = bstTree.insertNode(null,10);

        Node leftNode = bstTree.insertLeftNode(rootNode,2);
        Node rightNode = bstTree.insertRightNode(rootNode,10);

        Node leftNode1 = bstTree.insertLeftNode(leftNode,20);
        Node rightNode1 = bstTree.insertRightNode(leftNode,1);

        Node rightNode2=bstTree.insertRightNode(rightNode,10);

        Node rightNode3 = bstTree.insertRightNode(rightNode2,-25);

        Node leftNode2 = bstTree.insertLeftNode(rightNode3,3);
        Node rightNode4 = bstTree.insertRightNode(rightNode3,4);

        return rootNode;
    }
    public Node getLinkedListTree(){

        BST bsTree = new BST();

        Node rootNode = bsTree.insertNode(null,3);

        Node leftNode = bsTree.insertLeftNode(rootNode,5);
        Node rightNode = bsTree.insertRightNode(rootNode,2);

        Node leftNode1 = bsTree.insertLeftNode(rightNode,1);

        Node leftNode2 = bsTree.insertLeftNode(leftNode1,4);
        Node rightNode1 = bsTree.insertRightNode(leftNode1,6);

        return rootNode;
    }
    public Node topViewSkewedTreeView(){

        BST bsTree = new BST();

        Node rootNode = bsTree.insertNode(null,6);


        Node leftNode = bsTree.insertLeftNode(rootNode,2);
        Node rightNode = bsTree.insertRightNode(rootNode,1);

        Node rightNode1 = bsTree.insertRightNode(leftNode,3);

        Node rightNode2 = bsTree.insertRightNode(rightNode1,4);

        Node rightNode3 = bsTree.insertRightNode(rightNode,5);

        return rootNode;
    }

    public Node getSkewedTreeForTreeView(){

        BST bsTree = new BST();

        Node rootNode = bsTree.insertNode(null,1);

        Node leftNode = bsTree.insertLeftNode(rootNode,2);
        Node rightNode = bsTree.insertRightNode(rootNode,3);

        Node leftNode1 = bsTree.insertLeftNode(leftNode,4);
        Node rightNode1 = bsTree.insertRightNode(leftNode,5);

        Node leftNode2 = bsTree.insertLeftNode(rightNode1,6);
        Node rightNode2 = bsTree.insertRightNode(rightNode1,7);

        return rootNode;

    }
    public Node getSymmetricTree(){

        BST bsTree = new BST();

        Node rootNode = bsTree.insertNode(null,1);

        Node leftNode = bsTree.insertLeftNode(rootNode,2);
        Node rightNode = bsTree.insertRightNode(rootNode,2);

        Node leftNode1 =  bsTree.insertLeftNode(leftNode,3);
        Node rightNode1 = bsTree.insertRightNode(leftNode,4);

        Node leftNode2 = bsTree.insertLeftNode(leftNode1,5);

        Node leftNode3 = bsTree.insertLeftNode(rightNode,4);
        Node rightNode3 = bsTree.insertRightNode(rightNode,3);

        Node rightNode4 = bsTree.insertRightNode(rightNode3,5);


        return rootNode;
    }

    public Node getSumTree1(){

        BST bsTree = new BST();

        Node rootNode = bsTree.insertNode(null,70);

        Node leftNode = bsTree.insertLeftNode(rootNode,20);
        Node rightNode = bsTree.insertRightNode(rootNode,30);

        Node leftNode1 = bsTree.insertLeftNode(leftNode,10);
        Node rightNode1 = bsTree.insertRightNode(leftNode,10);

        return rootNode;
    }
    public Node getBSTTree1(){

        BST bsTree = new BST();

        Node rootNode = bsTree.insertNode(null,1);
        Node leftNode1 = bsTree.insertLeftNode(rootNode,5);
        Node rightNode1 = bsTree.insertRightNode(rootNode,2);

        Node leftNode2 = bsTree.insertLeftNode(leftNode1,6);
        Node rightNode3 = bsTree.insertRightNode(leftNode2,7);
        Node leftNode4 = bsTree.insertLeftNode(rightNode3,8);
        Node rightNode4 = bsTree.insertRightNode(rightNode3,9);

        Node leftNode5 = bsTree.insertLeftNode(rightNode1,3);
        Node rightNode5 = bsTree.insertRightNode(rightNode1,4);

        return rootNode;
    }


    public Node getDiagonalViewTree(){

        BST bstTree = new BST();
        Node rootNode = bstTree.insertNode(null,8);

        Node leftNode = bstTree.insertLeftNode(rootNode,3);
        Node rightNode = bstTree.insertRightNode(rootNode,10);

        Node leftNode1 = bstTree.insertLeftNode(leftNode,1);
        Node rightNode1 = bstTree.insertRightNode(leftNode,6);

        Node leftNode2 = bstTree.insertLeftNode(rightNode1,4);
        Node rightNode2 = bstTree.insertRightNode(rightNode1,7);

        Node rightNode3 = bstTree.insertRightNode(rightNode,5);
        Node leftNode3 = bstTree.insertLeftNode(rightNode3,2);


        return rootNode;
    }


    public Node getKSumTree(){

        BST bstTree = new BST();

        Node rootNode = bstTree.insertNode(null,1);

        Node leftNode = bstTree.insertLeftNode(rootNode,3);
        Node rightNode = bstTree.insertRightNode(rootNode,-1);

        Node lefNode1 = bstTree.insertLeftNode(leftNode,2);
        Node rightNode1 = bstTree.insertRightNode(leftNode,1);

        Node leftNode2 = bstTree.insertLeftNode(rightNode1,1);

        Node leftNode3 = bstTree.insertLeftNode(rightNode,4);
        Node rightNode3 = bstTree.insertRightNode(rightNode,5);

        Node leftNode4 = bstTree.insertLeftNode(leftNode3,1);
        Node rightNode4= bstTree.insertRightNode(leftNode3,2);


       Node rightNode5 = bstTree.insertRightNode(rightNode3,6);

       return rootNode;
    }
    public Node getSumTree(){

        BST bsTree = new BST();

        Node rootNode = bsTree.insertNode(null,10);

        Node leftNode = bsTree.insertLeftNode(rootNode,-2);
        Node rightNode = bsTree.insertRightNode(rootNode,6);

        Node leftNode1 = bsTree.insertLeftNode(leftNode,8);
        Node rightNode1 = bsTree.insertRightNode(leftNode,-4);

        Node leftNode2 = bsTree.insertLeftNode(rightNode,7);
        Node rightNode2 = bsTree.insertRightNode(rightNode,5);

        return rootNode;
    }
    public Node getBSTTree() {

        BST bsTree = new BST();

        Node rootNode = bsTree.insertNode(null,1);
        Node leftNode1 = bsTree.insertLeftNode(rootNode,2);
        Node rightNode1 = bsTree.insertRightNode(rootNode,3);

        Node leftNode2 = bsTree.insertLeftNode(leftNode1,4);
        Node rightNode2 = bsTree.insertRightNode(leftNode1,5);

        Node leftNode3 = bsTree.insertLeftNode(rightNode1,6);
        Node rightNode3 = bsTree.insertRightNode(rightNode1,7);

        Node leftNode4= bsTree.insertLeftNode(rightNode3,8);

        Node leftNode5 = bsTree.insertLeftNode(leftNode4,9);

        return rootNode;
    }

}
