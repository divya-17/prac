package graphs.MST.kruskalsAlgo;

import graphs.detectCycle.directedGraph.Graph;
import javafx.util.Pair;

import java.util.*;

public class Main {


    private static Map<Integer, List<Pair>> graphAdjList = new HashMap<>();
    private static List<GraphPath> graphPaths = new ArrayList<>();
    private static MSTNode[] mstNodeArr = new MSTNode[9];
    private static List<GraphPath> finalMSTPaths = new ArrayList<>();

    private static int numVertices;

    public static void main(String[] args) {


        initializeGraph();
        for(Map.Entry<Integer,List<Pair>> entry: graphAdjList.entrySet()){

            for(Pair<Integer,Integer> connVertices: entry.getValue()){

                GraphPath gp1 = new GraphPath(entry.getKey(),connVertices.getKey(),connVertices.getValue());
                graphPaths.add(gp1);
            }
        }

        Collections.sort(graphPaths, new Comparator<GraphPath>() {
            @Override
            public int compare(GraphPath o1, GraphPath o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });

        System.out.println("Sorted graph paths is => "+graphPaths);
        
        createMSTGraph();

        System.out.println("MST Path is "+finalMSTPaths);
        
    }

    private static void createMSTGraph() {
    
        for(GraphPath path: graphPaths){

            if(finalMSTPaths.size() == numVertices-1){
                return;
            }

            MSTNode srcNode= mstNodeArr[path.getSrcNode()];
            MSTNode dstNode = mstNodeArr[path.getDstNode()];

            Integer srcAbsParent = getAbsoluteParentNode(srcNode);
            Integer dstAbsParent = getAbsoluteParentNode(dstNode);

            if((srcAbsParent== -1 && dstAbsParent == -1) ||
                    srcAbsParent != dstAbsParent){

                unionNodeByRank(srcNode,dstNode);
                finalMSTPaths.add(path);
            }

        }
    }

    private static Integer getAbsoluteParentNode(MSTNode srcNode) {

        if(srcNode.getParentNode() == -1){
            return srcNode.getNodeValue();
        }
        if(srcNode.getParentNode() == srcNode.getAbsoluteParentNode()){
            return srcNode.getParentNode();
        }
        Integer absParentNode = getAbsoluteParentNode(mstNodeArr[srcNode.getParentNode()]);
        srcNode.setAbsoluteParentNode(absParentNode);
        return absParentNode;
    }

    private static void unionNodeByRank(MSTNode srcNode, MSTNode dstNode) {

        if (srcNode.getRank() < dstNode.getRank()){
            srcNode.setParentNode(dstNode.getNodeValue());
        }
        else if (srcNode.getRank() > dstNode.getRank()){
            dstNode.setParentNode(srcNode.getNodeValue());
        }
        else if (srcNode.getRank() == dstNode.getRank()){
            srcNode.setParentNode(dstNode.getNodeValue());
            dstNode.setRank(dstNode.getRank()+1);
        }
    }


    private static void initializeGraph() {


        graphAdjList.put(0,new ArrayList<>(Arrays.asList(new Pair(1,1),new Pair(2,2))));
        graphAdjList.put(1,new ArrayList<>(Arrays.asList(new Pair(2,1),new Pair(3,3))));
        graphAdjList.put(2,new ArrayList<>(Arrays.asList(new Pair(3,4))));

        MSTNode node0 = new MSTNode(0);
        mstNodeArr[0] = node0;
        MSTNode node1 = new MSTNode(1);
        mstNodeArr[1] = node1;
        MSTNode node2 = new MSTNode(2);
        mstNodeArr[2] = node2;
        MSTNode node3 = new MSTNode(3);
        mstNodeArr[3] = node3;

        numVertices=4;


//        graphAdjList.put(0,new ArrayList(Arrays.asList(new Pair(1,4),new Pair(7,8))));
//        graphAdjList.put(1,new ArrayList(Arrays.asList(new Pair(2,8),new Pair(7,11))));
//        graphAdjList.put(2,new ArrayList(Arrays.asList(new Pair(8,2),new Pair(3,7),new Pair(5,4))));
//        graphAdjList.put(3,new ArrayList(Arrays.asList(new Pair(5,14),new Pair(4,9))));
//        graphAdjList.put(4,new ArrayList(Arrays.asList(new Pair(5,10))));
//        graphAdjList.put(5,new ArrayList(Arrays.asList(new Pair(6,2))));
//        graphAdjList.put(6,new ArrayList(Arrays.asList(new Pair(8,6), new Pair(7,1))));
//        graphAdjList.put(7,new ArrayList(Arrays.asList(new Pair(8,7))));
//
//        MSTNode node0 = new MSTNode(0);
//        mstNodeArr[0] = node0;
//        MSTNode node1 = new MSTNode(1);
//        mstNodeArr[1] = node1;
//        MSTNode node2 = new MSTNode(2);
//        mstNodeArr[2] = node2;
//        MSTNode node3 = new MSTNode(3);
//        mstNodeArr[3] = node3;
//        MSTNode node4 = new MSTNode(4);
//        mstNodeArr[4] = node4;
//        MSTNode node5 = new MSTNode(5);
//        mstNodeArr[5] = node5;
//        MSTNode node6 = new MSTNode(6);
//        mstNodeArr[6] = node6;
//        MSTNode node7 = new MSTNode(7);
//        mstNodeArr[7] = node7;
//        MSTNode node8 = new MSTNode(8);
//        mstNodeArr[8] = node8;
    }
}
