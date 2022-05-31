package binaryTrees.Ques;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

    public static void main(String[] args) {

        App app = new App();
        Node rootNode = app.getBSTTree();

        Queue orderQueue = new LinkedList();

        orderQueue.add(rootNode);
        Stack<Node> resultStack = getReverseLevelOrderTraversal(orderQueue, new Stack<Node>());

        while (!resultStack.isEmpty()){

            System.out.println(resultStack.pop().getData());
        }
    }

    private static Stack<Node> getReverseLevelOrderTraversal(Queue<Node> orderQueue, Stack<Node> nodeStack) {


        while (!orderQueue.isEmpty()){

            Node currNode = orderQueue.poll();
            nodeStack.add(currNode);

            if(currNode.getRightNode() != null){
                orderQueue.add(currNode.getRightNode());
            }
            if(currNode.getLeftNode() != null){
                orderQueue.add(currNode.getLeftNode());
            }
            getReverseLevelOrderTraversal(orderQueue,nodeStack);
        }
        return nodeStack;
    }
}
