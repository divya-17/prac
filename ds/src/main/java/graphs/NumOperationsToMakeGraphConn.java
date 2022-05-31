package graphs;

import javafx.util.Pair;

import java.util.*;

/*
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

Example 1:
Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3


Example 2:
Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2

Example 3:
Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables connections[10][0] = 2;
        connections[10][1] = 6;


 */
public class NumOperationsToMakeGraphConn {

    private static Map<Integer,List<Integer>> adjNodesMap;

    private static Integer totalMarkedNodes=0;

    public static void main(String[] args) {


        boolean[] visitedArr = new boolean[100];
        Arrays.fill(visitedArr,false);

        //TC:1
//        int[][] connections = new int[5][2];
//        connections[0][0] = 0;
//        connections[0][1] = 1;
//
//        connections[1][0] = 0;
//        connections[1][1] = 2;
//
//        connections[2][0] = 0;
//        connections[2][1] = 3;
//
//        connections[3][0] = 1;
//        connections[3][1] = 2;
//
//        connections[4][0] = 1;
//        connections[4][1] = 3;


   // TC: 2

//        int[][] connections = new int[4][2];
//
//        connections[0][0] = 0;
//        connections[0][1] = 1;
//
//        connections[1][0] = 0;
//        connections[1][1] = 2;
//
//        connections[2][0] = 0;
//        connections[2][1] = 3;
//
//        connections[3][0] = 1;
//        connections[3][1] = 2;


        int[][] connections = new int[13][2];

        connections[0][0] = 1;
        connections[0][1] = 5;

        connections[1][0] = 1;
        connections[1][1] = 7;

        connections[2][0] = 1;
        connections[2][1] = 2;

        connections[3][0] = 1;
        connections[3][1] = 4;

        connections[4][0] = 3;
        connections[4][1] = 7;

        connections[5][0] = 4;
        connections[5][1] = 7;

        connections[6][0] = 3;
        connections[6][1] = 5;

        connections[7][0] = 0;
        connections[7][1] = 6;

        connections[8][0] = 0;
        connections[8][1] = 1;

        connections[9][0] = 0;
        connections[9][1] = 4;

        connections[10][0] = 2;
        connections[10][1] = 6;

        connections[11][0] = 0;
        connections[11][1] = 3;

        connections[12][0] = 0;
        connections[12][1] = 2;



        int n = 12;

        if(connections.length <  n-1){
            System.out.println("Not possible. Answer: "+(-1));
        }
        adjNodesMap = new HashMap<>();
        //int n = 6;
        createGraph(connections);
        int componentCount = 0;

        for(int i = 0; i < n; i++){

            if(!visitedArr[i]){
                componentCount++;
                markAllConnectedNodesRecursively(i,adjNodesMap,visitedArr);
            }
        }

        System.out.println("Answer "+(componentCount-1));
    }

    private static void markAllConnectedNodesRecursively(Integer node, Map<Integer,
            List<Integer>> adjNodesMap, boolean[] visitedArr) {

        if(adjNodesMap.get(node) != null) {
            for (Integer val : adjNodesMap.get(node)) {
                if (!visitedArr[val]) {
                    visitedArr[val] = true;
                    totalMarkedNodes++;
                    markAllConnectedNodesRecursively(val, adjNodesMap, visitedArr);
                }
            }
        }
    }

    private static void createGraph(int[][] connections) {

        for(int i =0; i < connections.length; i++){
            if(adjNodesMap.containsKey(connections[i][0])){
                adjNodesMap.get(connections[i][0]).add(connections[i][1]);
            }
            else{
                adjNodesMap.put(connections[i][0],new ArrayList<>(Arrays.asList(connections[i][1])));
            }

            if(adjNodesMap.containsKey(connections[i][1])){
                adjNodesMap.get(connections[i][1]).add(connections[i][0]);
            }
            else{
                adjNodesMap.put(connections[i][1],new ArrayList<>(Arrays.asList(connections[i][0])));
            }
        }
    }

    class Node{

        int val;
        boolean visited;

        public Node(){}

        public Node(int val){this.val = val;
            visited = false;}

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public boolean isVisited() { return visited; }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        @Override
        public String toString() {
            return "graphs.Node{" +
                    "val=" + val +
                    ", visited=" + visited +
                    '}';
        }
    }
}

