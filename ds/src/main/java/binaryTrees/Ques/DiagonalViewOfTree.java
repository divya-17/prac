package binaryTrees.Ques;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalViewOfTree {

    private static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) {

        App app = new App();
        Node rootNode = app.getDiagonalViewTree();


        printTreeDiagonally(rootNode);
    }

    private static void printTreeDiagonally(Node rootNode) {

        if(rootNode == null){
            return;
        }
        System.out.print(rootNode.getData()+",");
        if(rootNode.getLeftNode() != null){
            queue.add(rootNode.getLeftNode());
        }
        printTreeDiagonally(rootNode.getRightNode());

        if(!queue.isEmpty()) {
            Node curNode = queue.poll();
            printTreeDiagonally(curNode);
        }
    }
}
