package binaryTrees.Ques;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
Given a binary tree find all paths going downwards that sums up to K.

INCOMPLETE
 */
public class PrintKSumPaths {

    private static Stack<Integer> treeStack = new Stack<>();
    private static List<List<Integer>> allPossiblePaths = new ArrayList<>();

    public static void main(String[] args) {

        App app = new App();
        Node rootNode = app.getBSTTree();

        System.out.println(rootNode);

        int k = 10;

        getAllKSumPath(rootNode,k,treeStack);
        System.out.println(allPossiblePaths);

    }

    private static void getAllKSumPath(Node rootNode, int k, Stack<Integer> treeStack) {

        if(rootNode == null){
            return;
        }
        treeStack.push(rootNode.getData());

        getAllKSumPath(rootNode.getLeftNode(),k,treeStack);

        getAllKSumPath(rootNode.getRightNode(),k,treeStack);

        System.out.println(treeStack);
        checkAllPossiblePaths(treeStack,k);

        treeStack.pop();
    }

    private static void checkAllPossiblePaths(Stack<Integer> treeStack, int targetSum) {

        List<Integer> currLevelElemList = treeStack;
        List<Integer> currPath = new ArrayList<>();

        int sum = 0;
        for(int i = currLevelElemList.size()-1; i >= 0; i--){
            currPath.add(currLevelElemList.get(i));
            sum = sum+currLevelElemList.get(i);

            if(sum == targetSum){
                allPossiblePaths.add(new ArrayList<>(currPath));
            }

        }
    }
}
