package binaryTrees.Ques;

import binaryTrees.createTree.Node;

import java.util.HashMap;
import java.util.Map;

/*
Given an inorder and pre-order traversal of the tree in form of array, construct a complete binary tree from it.
 */
public class constructTreeFromInOrderAndPreOrder {

    private static int index = 0;

    private static Map<Integer,Integer> indexMap = new HashMap<>();

    public static void main(String[] args) {

        int[] inOrder = new int[] {4, 2, 5, 1, 3};
        int[] preOrder = new int[] {1, 2, 4, 5, 3};

        createIndexMap(inOrder);

        Node rootNode = constructCompleteBinaryTree(preOrder,inOrder,0,preOrder.length-1);

        System.out.println(rootNode);

    }

    private static void createIndexMap(int[] inOrder) {

        for(int i =0; i < inOrder.length; i++){
            if(!indexMap.containsKey(inOrder[i])){
                indexMap.put(inOrder[i],i);
            }
        }
    }

    private static Node constructCompleteBinaryTree(int[] preOrder, int[] inOrder, int low, int high) {


        if(low > high) return null;

        Node newNode = new Node(preOrder[index++]);

        if(low == high){
            return newNode;
        }
        int mid = indexMap.get(newNode.getData());

        newNode.setLeftNode(constructCompleteBinaryTree(preOrder,inOrder,0,mid-1));
        newNode.setRightNode(constructCompleteBinaryTree(preOrder,inOrder,mid+1,high));

        return newNode;
    }
}

