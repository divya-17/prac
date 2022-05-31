package binaryTrees.Ques;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

import java.util.ArrayList;
import java.util.List;

/*
Different tree traversals:

1- Pre Order Traversal : [Root , Left, Right]
2- Post Order Traversal: [Left, Right, Root]
3- In Order Traversal: [Left, Root, Right

 */
public class Traversals {

    public static void main(String[] args) {

        App app = new App();

        List<Integer> preOrderList = new ArrayList<>();
        List<Integer> inOrderList = new ArrayList<>();
        List<Integer> postOrderList = new ArrayList<>();


        Node rootNode = app.getBSTTree();
        System.out.println(rootNode);

        preOrderTraversal(rootNode,preOrderList);
        System.out.println(preOrderList);

        inOrderTraversal(rootNode,inOrderList);
        System.out.println(inOrderList);

        postOrderTraversal(rootNode,postOrderList);
        System.out.println(postOrderList);

    }

    private static void postOrderTraversal(Node rootNode, List<Integer> postOrderList) {


        if(rootNode == null) return;

        postOrderTraversal(rootNode.getLeftNode(),postOrderList);
        postOrderTraversal(rootNode.getRightNode(),postOrderList);
        postOrderList.add(rootNode.getData());
    }

    private static void inOrderTraversal(Node rootNode, List<Integer> inOrderList) {
        if(rootNode == null){
            return;
        }

        if(rootNode != null){
                inOrderTraversal(rootNode.getLeftNode(),inOrderList);
                inOrderList.add(rootNode.getData());
                inOrderTraversal(rootNode.getRightNode(),inOrderList);

        }
    }

    private static void preOrderTraversal(Node rootNode,List<Integer> preOrderList) {

        if(rootNode != null) {
            preOrderList.add(rootNode.getData());
            preOrderTraversal(rootNode.getLeftNode(),preOrderList);
            preOrderTraversal(rootNode.getRightNode(),preOrderList);
        }
    }




}
