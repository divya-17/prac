package binaryTrees.Ques;


import binaryTrees.createTree.App;
import binaryTrees.createTree.BST;
import binaryTrees.createTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {

       App app = new App();
       Node rootNode =app.getBSTTree();

       Queue<Node> nodeQueue = new LinkedList<>();
       nodeQueue.add(rootNode);

       Queue<Node> nodeLevelQueue = new LinkedList<>();
       nodeLevelQueue.add(rootNode);
       // null is added to keep track of changing levels.
       nodeLevelQueue.add(null);

       getLevelTraversal(nodeQueue);

        System.out.println(" ====================== ");
       getLevelOrderTraversalInDiffLines(nodeLevelQueue);

    }

    private static void getLevelTraversal(Queue<Node> nodeQueue) {

        while (!nodeQueue.isEmpty()){

            Node currNode = nodeQueue.poll();
            System.out.println(currNode.getData());

            if(currNode.getLeftNode()!= null){
                nodeQueue.add(currNode.getLeftNode());
            }
            if(currNode.getRightNode() != null){
                nodeQueue.add(currNode.getRightNode());
            }
            getLevelTraversal(nodeQueue);
        }
    }

    // Print level order traversal such that all elements of same level get's printed in same line.
    // and each level elements are in diff lines
    private static void getLevelOrderTraversalInDiffLines(Queue<Node> nodeLevelQueue){

        while (!nodeLevelQueue.isEmpty()){

            Node currNode = nodeLevelQueue.poll();

            if(currNode == null){
                if(!nodeLevelQueue.isEmpty()){
                    nodeLevelQueue.add(null);
                    System.out.println();
                }
                else  return;
            }

            else{
                System.out.print(currNode.getData()+" ");
                if(currNode.getLeftNode() != null){
                    nodeLevelQueue.add(currNode.getLeftNode());
                }
                if(currNode.getRightNode() != null){
                    nodeLevelQueue.add(currNode.getRightNode());
                }
            }
        }
    }
}
