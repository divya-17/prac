import javafx.util.Pair;

import java.util.*;

public class MinDistForFarthestNode {

    public static void main(String[] args) {

        //int [][] networkDelayInfo = new int[][] {{5,1,1},{5,2,2},{1,4,2},{1,3,5},{2,3,1}};

        int[][] networkDelayInfo = new int[][]{{4, 2, 76}, {1, 3, 79}, {3, 1, 81}, {4, 3, 30}, {2, 1, 47}, {1, 5, 61}, {1, 4, 99},
                {3, 4, 68}, {3, 5, 46}, {4, 1, 6}, {5, 4, 7}, {5, 3, 44}, {4, 5, 19}, {2, 3, 13}, {3, 2, 18}, {1, 2, 0}, {5, 1, 25}, {2, 5, 58},
                {2, 4, 77}, {5, 2, 74}};
        int numNodes = 5;
        int srcNode = 3;

        int output = getNetworkDelay(networkDelayInfo, numNodes, srcNode);
        System.out.println("Output " + output);
    }

    private static int getNetworkDelay(int[][] networkDelayInfo, int numNodes, int srcNode) {


        NodeInfo[] nodeInfos = new NodeInfo[numNodes];
        PriorityQueue<NodeInfo> nodeWeightQueue = new PriorityQueue<>(new Comparator<NodeInfo>() {
            @Override
            public int compare(NodeInfo o1, NodeInfo o2) {
                if(o1.getTravelTime() < o2.getTravelTime()){
                    return -1;
                }
                else if(o1.getTravelTime() > o2.getTravelTime()){
                    return 1;
                }
                return 0;
            }
        });
        populateNodeInfos(nodeInfos, numNodes);

        //printNodeInfos(nodeInfos,numNodes);

        Map<NodeInfo, List<Pair<NodeInfo, Integer>>> nodeConnectivityMap = new HashMap<>();


        for (int row = 0; row < networkDelayInfo.length; row++) {

            int strtNode = networkDelayInfo[row][0];

            int destNode = networkDelayInfo[row][1];

            int weight = networkDelayInfo[row][2];

            NodeInfo node = nodeInfos[strtNode - 1];


            if (nodeConnectivityMap.containsKey(node)) {
                List<Pair<NodeInfo, Integer>> connectingNodeList = nodeConnectivityMap.get(node);
                connectingNodeList.add(new Pair<>(nodeInfos[destNode - 1], weight));
            } else {
                nodeConnectivityMap.put(nodeInfos[strtNode - 1],
                        new ArrayList<>(Arrays.asList(new Pair<>(nodeInfos[destNode - 1], weight))));
            }
        }
        //printNodeConnectivityMap(nodeConnectivityMap);

        // BFS
        nodeInfos[srcNode - 1].setTravelTime(0);

        for(int i =0 ; i < numNodes; i++){
            nodeWeightQueue.add(nodeInfos[i]);
        }

        int maxTravelTime = 0;

        while (!nodeWeightQueue.isEmpty()) {

            NodeInfo minWeightNode = nodeWeightQueue.poll();

            if(!minWeightNode.isProcessed()) {

                List<Pair<NodeInfo, Integer>> connectingNodes = nodeConnectivityMap.get(minWeightNode);

                if (connectingNodes != null) {
                    for (Pair<NodeInfo, Integer> node : connectingNodes) {

                        if (node.getKey().getTravelTime() > minWeightNode.getTravelTime() + node.getValue()) {
                            Integer newTravelTime = minWeightNode.getTravelTime() + node.getValue();
                            node.getKey().setTravelTime(newTravelTime);
                        }
                        nodeWeightQueue.add(node.getKey());
                    }
                }
            }
            minWeightNode.setProcessed(true);
        }


        for (NodeInfo node : nodeInfos) {
            if(node.getTravelTime() == Integer.MAX_VALUE){
                return -1;
            }
            else  if (node.getTravelTime() > maxTravelTime) {
                    maxTravelTime = node.getTravelTime();
                }
        }

        return maxTravelTime;
    }

    private static void printNodeConnectivityMap(Map<NodeInfo, List<Pair<NodeInfo, Integer>>> nodeConnectivityMap) {

        for (Map.Entry<NodeInfo, List<Pair<NodeInfo, Integer>>> entry : nodeConnectivityMap.entrySet()) {
            System.out.println("KEY => " + entry.getKey());
            System.out.println("VALUE => " + entry.getValue());
        }
    }

    private static void printNodeInfos(NodeInfo[] nodeInfos, int numNodes) {
        for (int i = 0; i < numNodes; i++) {
            System.out.println(nodeInfos[i]);
        }
    }

    private static void populateNodeInfos(NodeInfo[] nodeInfos, int numNodes) {

        for (int i = 0; i < numNodes; i++) {
            nodeInfos[i] = new NodeInfo(i + 1);
        }
    }
}

class NodeInfo {

    private int nodeId;
    private int travelTime;
    private boolean isProcessed;

    public NodeInfo(int nodeId) {
        this.nodeId = nodeId;
        this.travelTime = Integer.MAX_VALUE;
        this.isProcessed = false;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public String toString() {
        return "NodeInfo{" +
                "nodeId=" + nodeId +
                ", travelTime=" + travelTime +
                '}';
    }
}

