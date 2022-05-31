package graphs.MST.primsAlgo;

import javafx.util.Pair;

import java.util.*;

/*

Given a connected graph with weight assigned to each edge, find the minimum spanning tree.
Minimum spanning tree is the tree with all edge connected such that the overall weightage of the graph is minimum.
 */
public class PrimsAlgo {

    private static Map<Integer, List<Pair<Integer,Integer>>> graphAdjList = new HashMap<>();
    private static List<Node> mst = new ArrayList<>();
    private static Node[] nodeArr = new Node[9];


    public static void main(String[] args) {


        initializeGraph();
        populateNodeArr();
        while (mst.size() < 9) {
            setMstNodes(getMinWeightNode(nodeArr));
        }
        System.out.println("MST Set Created !!");
        for(Node n: mst){
            System.out.println(n);
        }

    }

    private static Node getMinWeightNode(Node[] nodeArr) {

        int minWeight = Integer.MAX_VALUE;
        Node minWeightNode = null;

        for(int i =0 ; i < nodeArr.length; i++){

            if(!nodeArr[i].getIncludedInMSTSet() &&
                    nodeArr[i].getWeight() < minWeight){
                minWeight = nodeArr[i].getWeight();
                minWeightNode = nodeArr[i];
            }
        }
        //System.out.println("Min Weight is "+minWeight);

        return minWeightNode;
    }

    private static void populateNodeArr() {

        Node v0 = new Node(0,null,0);
        Node v1 = new Node(1);
        Node v2 = new Node(2);
        Node v3 = new Node(3);
        Node v4 = new Node(4);
        Node v5 = new Node(5);
        Node v6 = new Node(6);
        Node v7 = new Node(7);
        Node v8 = new Node(8);

        nodeArr[0] = v0;
        nodeArr[1] = v1;
        nodeArr[2] = v2;
        nodeArr[3] = v3;
        nodeArr[4] = v4;
        nodeArr[5] = v5;
        nodeArr[6] = v6;
        nodeArr[7] = v7;
        nodeArr[8] = v8;

    }

    private static void setMstNodes(Node strtNode) {


        mst.add(strtNode);
        strtNode.setIncludedInMSTSet(true);

        for(Pair<Integer,Integer> connectedVertex: graphAdjList.get(strtNode.vertexValue)){

            Node connectedNode = nodeArr[connectedVertex.getKey()];
            if(!connectedNode.getIncludedInMSTSet() &&
                    connectedNode.weight > connectedVertex.getValue()){
                connectedNode.setWeight(connectedVertex.getValue());
                connectedNode.setParentNode(strtNode);
            }
        }

    }

    private static void initializeGraph() {

        graphAdjList.put(0,new ArrayList(Arrays.asList(new Pair(1,4),new Pair(7,8))));
        graphAdjList.put(1,new ArrayList(Arrays.asList(new Pair(0,4),new Pair(2,8),new Pair(7,11))));
        graphAdjList.put(2,new ArrayList(Arrays.asList(new Pair(1,8),new Pair(8,2),new Pair(3,7),new Pair(5,4))));
        graphAdjList.put(3,new ArrayList(Arrays.asList(new Pair(2,7),new Pair(5,14),new Pair(4,9))));
        graphAdjList.put(4,new ArrayList(Arrays.asList(new Pair(3,9),new Pair(5,10))));
        graphAdjList.put(5,new ArrayList(Arrays.asList(new Pair(4,10),new Pair(3,14),new Pair(2,4),new Pair(6,2))));
        graphAdjList.put(6,new ArrayList(Arrays.asList(new Pair(5,2),new Pair(8,6), new Pair(7,1))));
        graphAdjList.put(7,new ArrayList(Arrays.asList(new Pair(6,1),new Pair(8,7),new Pair(1,11),new Pair(0,8))));
        graphAdjList.put(8,new ArrayList(Arrays.asList(new Pair(2,2),new Pair(6,6),new Pair(7,7))));

    }
}
