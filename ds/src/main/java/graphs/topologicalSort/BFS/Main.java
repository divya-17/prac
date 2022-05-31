package graphs.topologicalSort.BFS;

import java.util.*;

/*
Sorting graph topologicallyt using BFS:
https://www.youtube.com/watch?v=tggiFvaxjrY&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=14

 */
public class Main {

    public static void main(String[] args) {

        Map<Integer,Integer> inDegreeMap = new HashMap<>();
        Queue<Integer> inputQueue = new LinkedList<>();
        Queue<Integer> ansQueue = new LinkedList<>();
        Integer count = 0;


        Map<Integer, List<Integer>> adjList = new HashMap(){{
            put(0, new ArrayList(Arrays.asList(2,3)));
            put(3, new ArrayList(Arrays.asList(1)));
            put(4, new ArrayList(Arrays.asList(1,2)));
            put(5, new ArrayList(Arrays.asList(0, 2)));
        }};

        for(Map.Entry<Integer,List<Integer>> entry: adjList.entrySet()){

            for(Integer v: entry.getValue()){
                if(inDegreeMap.containsKey(v)){
                    Integer value = inDegreeMap.get(v);
                    inDegreeMap.put(v,value+1);
                }
                else {
                    inDegreeMap.put(v,1);
                }
            }

        }

        for(Integer value: adjList.keySet()){
            if(!inDegreeMap.containsKey(value)){
                count++;
                inputQueue.add(value);
            }
        }

        System.out.println("Input Queue: "+inputQueue);
        System.out.println("Indegree map: "+inDegreeMap);

        while (!inputQueue.isEmpty()){
            Integer currValue = inputQueue.poll();
            ansQueue.add(currValue);
            List<Integer> connVertices = adjList.get(currValue);
            if(connVertices != null) {
                for (Integer vertex : connVertices) {
                    int val = inDegreeMap.get(vertex);
                    inDegreeMap.put(vertex, val - 1);
                    if (inDegreeMap.get(vertex) == 0) {
                        count++;
                        inputQueue.add(vertex);
                    }
                }
            }
        }
        if(count == adjList.keySet().size()) {
            System.out.println("Answer seq is "+ansQueue);
        }
        else {
            System.out.println("Topological sort not possible as cycle exists in the graph!");
        }

    }
}
