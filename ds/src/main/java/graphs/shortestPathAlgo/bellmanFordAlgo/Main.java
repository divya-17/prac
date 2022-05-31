package graphs.shortestPathAlgo.bellmanFordAlgo;

// For detecting negative edge cycle.

import javafx.util.Pair;

import java.util.*;

public class Main {

    private static Node[] nodeArr = new Node[5];
    private static Map<Integer,List<Pair>> graphPathDetails = new HashMap<>();

    public static void main(String[] args) {

        initializeGraph();
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


        graphPathDetails.put(0,new ArrayList(Arrays.asList(new Pair(1,1),new Pair(2,4))));
        graphPathDetails.put(1,new ArrayList(Arrays.asList(new Pair(2,-2),new Pair(3,2))));
        graphPathDetails.put(2,new ArrayList(Arrays.asList(new Pair(3,3))));
        graphPathDetails.put(3,new ArrayList(Arrays.asList(new Pair(4,4))));
        graphPathDetails.put(4,new ArrayList(Arrays.asList(new Pair(1,-3))));
    }


}
