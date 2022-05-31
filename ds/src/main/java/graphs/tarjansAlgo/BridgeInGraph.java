package graphs.tarjansAlgo;

import javafx.util.Pair;

import java.util.*;

/*
Given a graph, find all edges that are bridge in the graph. Bridge edges are those edges which if broken, will
result in entire graphs breaking into multiple components.
 */
public class BridgeInGraph {

    private static Integer timeCounter = -1;
    private static List<Pair<Integer,Integer>> bridgeEdgeList = new ArrayList<>();


    public static void main(String[] args) {

        Map<Node, List<Node>> adjGraphMap = new HashMap<>();
        List<Node> nodeList = new LinkedList<>();


        Node startNode = constructGraph(adjGraphMap,nodeList);


        //System.out.println(nodeList);
        dfsTraversal(startNode,adjGraphMap);
        System.out.println(nodeList);
        System.out.println(bridgeEdgeList);

    }

    private static Integer dfsTraversal(Node startNode, Map<Node, List<Node>> adjGraphMap) {

        timeCounter++;

        startNode.setDiscTime(timeCounter);
        startNode.setLowTime(timeCounter);

        Integer lowValue = startNode.getLowTime();

        if(adjGraphMap.get(startNode) != null) {

            for (Node connNode : adjGraphMap.get(startNode)) {

                if (connNode.nodeValue != startNode.parentNode) {
                    if(connNode.discTime == -1) {
                        connNode.setParentNode(startNode.getNodeValue());
                        lowValue = dfsTraversal(connNode, adjGraphMap);
                        if(startNode.getLowTime() > lowValue){
                            startNode.setLowTime(lowValue);
                        }
                        if(connNode.getLowTime() > startNode.getLowTime()){
                            bridgeEdgeList.add(new Pair(startNode.nodeValue,connNode.nodeValue));
                        }
                    }
                    // disTime != -1 means Back Edge detected!
                    else{
                         lowValue = Math.min(startNode.getLowTime(),connNode.getDiscTime());
                         startNode.setLowTime(lowValue);
                    }
                }
            }
        }
        return lowValue;
    }

    private static Node constructGraph(Map<Node, List<Node>> adjGraphMap, List<Node> nodeList) {

        Node n0 = new Node(0);
        nodeList.add(n0);
        Node n1 = new Node(1);
        nodeList.add(n1);
        Node n2 = new Node(2);
        nodeList.add(n2);
        Node n3 = new Node(3);
        nodeList.add(n3);
        Node n4 = new Node(4);
        nodeList.add(n4);

        adjGraphMap.put(n0,new ArrayList<>(Arrays.asList(n1,n2,n3)));
        adjGraphMap.put(n1,new ArrayList<>(Arrays.asList(n0,n2)));
        adjGraphMap.put(n2,new ArrayList<>(Arrays.asList(n1,n0)));
        adjGraphMap.put(n3,new ArrayList<>(Arrays.asList(n0,n4)));

        return n0;
    }
}
class Node{

    Integer discTime;
    Integer lowTime;
    Integer parentNode;
    Integer nodeValue;

    public Node(Integer nodeValue){

        this.nodeValue = nodeValue;
        discTime = -1;
        lowTime = -1;
        parentNode = -1;
    }

    public Integer getDiscTime() {
        return discTime;
    }

    public void setDiscTime(Integer discTime) {
        this.discTime = discTime;
    }

    public Integer getLowTime() {
        return lowTime;
    }

    public void setLowTime(Integer lowTime) {
        this.lowTime = lowTime;
    }

    public Integer getParentNode() {
        return parentNode;
    }

    public void setParentNode(Integer parentNode) {
        this.parentNode = parentNode;
    }

    public Integer getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(Integer nodeValue) {
        this.nodeValue = nodeValue;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + nodeValue +
                " ,disT=" + discTime +
                ", lowT=" + lowTime +
                ", PN=" + parentNode +
                '}';
    }
}

