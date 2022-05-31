package practice;

import java.util.*;

public class CycleInUndirectedGraph {


    private static Map<Integer, List<Integer>> adjList ;
    private static boolean [] visitedArr;
    private static boolean cycleFound = false;

    public static void main(String[] args) {


        adjList = new HashMap<>();
        visitedArr=new boolean[6];

        adjList.put(1,new ArrayList<>(Arrays.asList(2,4)));
        adjList.put(2,new ArrayList<>(Arrays.asList(3,1)));
        adjList.put(3,new ArrayList<>(Arrays.asList(4,2)));
        adjList.put(4,new ArrayList<>(Arrays.asList(1,3)));


        boolean result = detectCycle(1, adjList, visitedArr, -1);
        System.out.println(result);
    }

    private static boolean detectCycle(int currVertex, Map<Integer, List<Integer>> adjList, boolean[] visitedArr,int parentNode) {

        if(!visitedArr[currVertex]){
            visitedArr[currVertex] = true;
            if(adjList.get(currVertex) != null){
                for(Integer conn: adjList.get(currVertex)){
                    if(conn != parentNode){
                        detectCycle(conn,adjList,visitedArr,currVertex);
                    }
                }
            }
        }
        else {
            cycleFound = true;
        }
        return cycleFound;
    }

}
