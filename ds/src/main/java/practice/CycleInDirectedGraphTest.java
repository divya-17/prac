package practice;

import java.util.*;

public class CycleInDirectedGraphTest {

    private static Map<Integer,List<Integer>> adjMap;
    private static Stack<Integer> orderStack;
    private static boolean[] visitedArr;
    private static boolean isCycleFound;

    public static void main(String[] args) {

        adjMap  = new HashMap<>();

        // Non-cyclic Graph
        adjMap.put(1,new ArrayList<>(Arrays.asList(2,4)));
        adjMap.put(2,new ArrayList<>(Arrays.asList(3)));
        adjMap.put(3,new ArrayList<>(Arrays.asList(4)));


        isCycleFound = false;
        // Cyclic Graph

//        adjMap.put(1,new ArrayList<>(Arrays.asList(2)));
//        adjMap.put(2,new ArrayList<>(Arrays.asList(3)));
//        adjMap.put(3,new ArrayList<>(Arrays.asList(4)));
//        adjMap.put(4,new ArrayList<>(Arrays.asList(1)));

        orderStack = new Stack<>();
        visitedArr = new boolean[5];

        Boolean isCyclic = detectCyle(1,adjMap,orderStack);

        System.out.println(isCyclic);

    }

    private static Boolean detectCyle(Integer vertex,Map<Integer, List<Integer>> adjMap,Stack<Integer> orderStack) {

        if(!visitedArr[vertex]){
            visitedArr[vertex] = true;
            orderStack.push(vertex);

            if(adjMap.get(vertex) != null){
                for(Integer conn: adjMap.get(vertex)) {
                    detectCyle(conn, adjMap, orderStack);
                }
            }

            orderStack.pop();
        }
        else {
            if(orderStack.contains(vertex)){
                isCycleFound=true;
            }
        }

        return isCycleFound;
    }
}
