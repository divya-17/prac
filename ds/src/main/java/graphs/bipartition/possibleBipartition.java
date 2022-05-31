package graphs.bipartition;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;

import java.util.*;

/*

Given a set of number n, we would like to split  everyone in two grps of any size .
Each person may dislike another person and they should not be in the same grp.

If dislike[i] = [a,b] then it means we can't put person a and b in the same group.

Return true if and only if it is possible to split everyone int two grps in this way.

Ex:

I/p: [[1,2],[1,3],[2,4]]
Output: true
Explaination: grp1 [1,4] and grp2 [2,3]


I/p: [[1,2],[1,3],[2,3]]
Output: false

I/p: [[1,2],[2,3][3,4][4,5][1,5]]
Output: false


If we create a graph using these points and there exist a cycle in that graph which is of odd length then that mean no valid bipartition is possible.

 */
public class possibleBipartition {

    public static void main(String[] args) {


        // Creating Vertices and adding them to vertex list
        List<Pair> inputPairs = new ArrayList<>(Arrays.asList(new Pair(1,2),new Pair(1,3),new Pair(2,4)));

        List<Pair> inputPairs1 = new ArrayList<>(Arrays.asList(new Pair(1,2),new Pair(2,3), new Pair(3,4), new Pair(4,5), new Pair(1,5)));

        Map<Vertex,List<Vertex>> connMap = new HashMap<>();
        List<Vertex> vertexList = new ArrayList<>();

        for(Pair p : inputPairs1){
            Integer v1 = Integer.parseInt(p.getKey().toString());
            Integer v2 = Integer.parseInt(p.getValue().toString());
            if(vertexList.isEmpty()){
                vertexList.add(new Vertex(v1));
                vertexList.add(new Vertex(v2));
            }
            else {
                if (v1 > vertexList.size()) {
                    vertexList.add(new Vertex(v1));
                }
                if (v2 > vertexList.size()) {
                    vertexList.add(new Vertex(v2));
                }
            }

            if(!connMap.containsKey(vertexList.get((v1-1)))){
                connMap.put(vertexList.get((v1-1)),new ArrayList<>(Arrays.asList(vertexList.get((v2-1)))));
            }
            else {
                List<Vertex> existingList = connMap.get(vertexList.get((v1-1)));
                existingList.add(vertexList.get((v2-1)));
                connMap.put(vertexList.get((v1-1)),existingList);
            }
        }

        System.out.println(connMap);

        /*
        Graph coloring approach to find possible cycle.
        Parent vertex will have RED color and all joining vertex will have GREEN color
        Any violation happening to this condition would indicate a cycle in the graph.
        */

        Boolean result = graphBiPartitionPossible(connMap);

        System.out.println("Bipartition possible: "+result);

    }

    private static Boolean graphBiPartitionPossible(Map<Vertex, List<Vertex>> connMap) {

       Queue<Vertex> vertexQueue = new LinkedList<>();
        Color currCol;

       for(Map.Entry<Vertex,List<Vertex>> entry: connMap.entrySet()){

           Vertex pV = entry.getKey();
           vertexQueue.add(pV);
           currCol = pV.getColor();
           if(currCol == Color.NOCOLOR){
               pV.setColor(Color.RED);
           }

           while (!vertexQueue.isEmpty()){

               Vertex currVertex = vertexQueue.poll();
               currCol = currVertex.getColor();
               if(connMap.get(currVertex) != null) {
                   for (Vertex connectingVertex : connMap.get(currVertex)) {

                       if (connectingVertex.getColor() == Color.NOCOLOR) {
                           if (currCol == Color.RED) {
                               connectingVertex.setColor(Color.GREEN);
                           } else if (currCol == Color.GREEN) {
                               connectingVertex.setColor(Color.RED);
                           }
                       } else {
                           if (connectingVertex.getColor() == currCol) {
                               return false;
                           }
                       }
                       vertexQueue.add(connectingVertex);
                   }
               }
           }
       }
       return true;
    }


}
