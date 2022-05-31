package graphs.shortestPathAlgo.dikstraAlgo;

import javafx.util.Pair;

import java.util.*;

//Find shortest path from src node to every other node in the graph.

public class Main {


    private static Node nodeArr[] = new Node[6];
    private static List<Node> finalShortestPathArr = new ArrayList<>();
    private Integer srcNode  = 0;
    private static Map<Integer, ArrayList> graphPathDetails = new HashMap<Integer, ArrayList>();

    public static void main(String[] args) {

        initializeGraph();

        // set weight of src node as 0 to start with.
        nodeArr[0].setWeight(0);

        while (finalShortestPathArr.size() != 6) {
            runDikstraAlgo();
        }

        System.out.println(finalShortestPathArr);
    }

    private static void runDikstraAlgo() {


        Node minWeightNode = findMinWeightNode();
        minWeightNode.setProcessed(true);

        finalShortestPathArr.add(minWeightNode);

        List<Pair> connVertices = graphPathDetails.get(minWeightNode.value);

        if(connVertices != null) {
            for (Pair p : connVertices) {

                Integer childNode = Integer.parseInt(p.getKey().toString());
                if (!nodeArr[childNode].getProcessed() &&
                        nodeArr[childNode].getWeight() > (Integer.parseInt(p.getValue().toString())) + (minWeightNode.getWeight())) {

                    nodeArr[childNode].setWeight(Integer.parseInt(p.getValue().toString()) + minWeightNode.getWeight());
                    nodeArr[childNode].setParentNode(minWeightNode.value);
                }
            }
        }
    }

    private static Node findMinWeightNode() {

        Node[] unprocessedNode = new Node[6];
        int startIndex = 0;

        for(int i=0; i < nodeArr.length; i++){
            if(!nodeArr[i].getProcessed()){
                unprocessedNode[startIndex++] = nodeArr[i];
            }
        }
        Arrays.sort(unprocessedNode, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {

                if(o1 == null || o2 == null){
                    return 1;
                }

                if(o1.getWeight() < o2.getWeight()){
                    return -1;
                }
                else if (o1.getWeight() > o2.getWeight()){
                    return 1;
                }
                return 0;
            }
        });
        return unprocessedNode[0];
    }

    private static void initializeGraph() {

        Node v0 = new Node(0);
        nodeArr[0] = v0;
        Node v1 = new Node(1);
        nodeArr[1] = v1;
        Node v2 = new Node(2);
        nodeArr[2] = v2;
        Node v3 = new Node(3);
        nodeArr[3] = v3;
        Node v4 = new Node(4);
        nodeArr[4] = v4;
        Node v5 = new Node(5);
        nodeArr[5] = v5;

        graphPathDetails.put(0,new ArrayList(Arrays.asList(new Pair(1,1),new Pair(2,4))));
        graphPathDetails.put(1,new ArrayList(Arrays.asList(new Pair(2,4),new Pair(3,2),new Pair(4,7))));
        graphPathDetails.put(2,new ArrayList(Arrays.asList(new Pair(4,5),new Pair(3,3))));
        graphPathDetails.put(3,new ArrayList(Arrays.asList(new Pair(4,4),new Pair(5,6))));
        graphPathDetails.put(4,new ArrayList(Arrays.asList(new Pair(5,7))));
    }
}
