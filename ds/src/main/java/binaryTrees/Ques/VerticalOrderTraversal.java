package binaryTrees.Ques;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

import java.util.*;

public class VerticalOrderTraversal {

    private static Map<Integer, List<Node>> treeNodeMap = new TreeMap<>();
    private static Queue<NodePair> nodePairQueue = new LinkedList();

    public static void main(String[] args) {

        App app = new App();
        Node rootNode = app.topViewSkewedTreeView();

        NodePair rootNodePair = new NodePair(rootNode,0);

        nodePairQueue.add(rootNodePair);

        getVerticalTraversal(nodePairQueue);
        System.out.println(treeNodeMap);

        for(Map.Entry<Integer,List<Node>> entry: treeNodeMap.entrySet()){

            for(Node node: entry.getValue()){
                System.out.print(node.getData()+" ");
            }
            System.out.println();
        }
    }

    private static void getVerticalTraversal(Queue<NodePair> nodePairQueue) {


        while(!nodePairQueue.isEmpty()){

            NodePair currNode = nodePairQueue.poll();

            if(!treeNodeMap.containsKey(currNode.getHeight())){
                LinkedList<Node> nodeList = new LinkedList<>();
                nodeList.add(currNode.getNode());
                treeNodeMap.put(currNode.getHeight(),nodeList);
            }
            else{
                List<Node> nodeList = treeNodeMap.get(currNode.getHeight());
                nodeList.add(currNode.getNode());
            }

            if(currNode.getNode().getLeftNode() != null){
                nodePairQueue.add(new NodePair(currNode.getNode().getLeftNode(),currNode.getHeight()-1));
            }
            if(currNode.getNode().getRightNode() != null){
               nodePairQueue.add(new NodePair(currNode.getNode().getRightNode(),currNode.getHeight()+1));
            }
        }

    }




}

