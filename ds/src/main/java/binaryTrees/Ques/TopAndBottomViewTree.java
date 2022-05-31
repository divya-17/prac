package binaryTrees.Ques;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopAndBottomViewTree {

    private static Queue<NodePair> topViewNodePairQueue = new LinkedList();
    private static Queue<NodePair> bottonViewNodePairQueue = new LinkedList();
    private static TreeMap<Integer,Node> topViewNodeTreeMap = new TreeMap();
    private static TreeMap<Integer,Node> bottonViewNodeTreeMap = new TreeMap<>();

    public static void main(String[] args) {

        App app = new App();
        Node rootNode = app.topViewSkewedTreeView();
        NodePair rootNodePair = new NodePair(rootNode,0);

        topViewNodePairQueue.add(rootNodePair);
        bottonViewNodePairQueue.add(rootNodePair);


        getTopViewTree(topViewNodePairQueue);
        System.out.println("Top View "+topViewNodeTreeMap);

        getBottonViewTree(bottonViewNodePairQueue);
        System.out.println("Bottom View "+bottonViewNodeTreeMap);
    }

    private static void getBottonViewTree(Queue<NodePair> bottonViewNodePairQueue) {

        while (!bottonViewNodePairQueue.isEmpty()){

            NodePair currNode = bottonViewNodePairQueue.poll();


            bottonViewNodeTreeMap.put(currNode.getHeight(),currNode.getNode());


            if(currNode.getNode().getRightNode() != null){
                bottonViewNodePairQueue.add(new NodePair(currNode.getNode().getRightNode(),currNode.getHeight()+1));
            }
            if(currNode.getNode().getLeftNode() != null){
                bottonViewNodePairQueue.add(new NodePair(currNode.getNode().getLeftNode(),currNode.getHeight()-1));
            }

        }
    }

    private static void getTopViewTree(Queue<NodePair> nodePairQueue) {

        while (!nodePairQueue.isEmpty()){

            NodePair currNode = nodePairQueue.poll();

            if(!topViewNodeTreeMap.containsKey(currNode.getHeight())){
                topViewNodeTreeMap.put(currNode.getHeight(),currNode.getNode());
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

class NodePair{

    private Node node;
    private int height;

    public NodePair(Node node, int height) {
        this.node = node;
        this.height = height;
    }

    public Node getNode() {
        return node;
    }

    public int getHeight() {
        return height;
    }
}