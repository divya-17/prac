package graphs.courseSchedule;

import graphs.bipartition.Color;
import javafx.util.Pair;

import java.util.*;

/*

Given a pair of courses where each pair of courses represent dependent courses, find out if there exist a
deadlock.

Eg:
[(0,1),(1,2),(2,3)]
Output: true -> [All courses can be completed without any dead lock]

[(1,4),(2,4),(2,5),(3,2),(4,3)]
Output: false  -> [There exist a deadlock. 4 -> 3 -> 2-> 4]

[(1,5),(1,4),(1,2),(4,3),(5,3)]
Output: true => [All courses can be completed without any dead lock]
 */
public class CourseSchedule {

    public static void main(String[] args) {

        // DEADLOCK
        List<Pair> vertexPair = new ArrayList<>(Arrays.asList(new Pair(1,4),new Pair(2,4),new Pair(2,5),new Pair(3,2),new Pair(4,3)));


        // NO DEADLOCK
        //List<Pair> vertexPair = new ArrayList<>(Arrays.asList(new Pair(1, 5), new Pair(1, 4), new Pair(1, 2), new Pair(4, 3), new Pair(5, 3)));
        Map<Vertex, List<Vertex>> connMap = new HashMap<>();

        List<Vertex> vertexList = new ArrayList<>();

        vertexList.add(new Vertex(1));
        vertexList.add(new Vertex(2));
        vertexList.add(new Vertex(3));
        vertexList.add(new Vertex(4));
        vertexList.add(new Vertex(5));


        for (Pair pair : vertexPair) {

            Integer num1 = Integer.parseInt(pair.getKey().toString());
            Integer num2 = Integer.parseInt(pair.getValue().toString());

            Vertex v = vertexList.get(num1 - 1);

            if (!connMap.containsKey(v)) {
                connMap.put(v, new ArrayList(Arrays.asList(vertexList.get(num2 - 1))));
            } else {
                List<Vertex> connectingVertices = connMap.get(v);
                connectingVertices.add(vertexList.get(num2 - 1));
            }
        }

        System.out.println(connMap);

        Boolean answer = detectDeadLock(connMap);
        System.out.println("All course completion possible => " + !answer);

    }

    private static Boolean detectDeadLock(Map<Vertex, List<Vertex>> connMap) {

        Queue<Vertex> processingQueue = new LinkedList<>();

        for (Map.Entry<Vertex, List<Vertex>> v : connMap.entrySet()) {

            if(v.getKey().getVertexColor() == Color.GREEN){
                continue;
            }

            processingQueue.add(v.getKey());

            while (!processingQueue.isEmpty()) {

                Vertex currVertex = processingQueue.poll();
                if (currVertex.getVertexColor() == Color.NOCOLOR) {
                    currVertex.setVertexColor(Color.RED);
                }

                if (connMap.get(currVertex) != null) {
                    for (Vertex connVertices : connMap.get(currVertex)) {
                        if (connVertices.getVertexColor() == Color.GREEN) {
                            System.out.println("Dead lock detected !!");
                            return true;
                        } else if (connVertices.getVertexColor() == Color.NOCOLOR) {
                            connVertices.setVertexColor(Color.RED);
                            processingQueue.add(connVertices);
                        }

                    }
                }
                currVertex.setVertexColor(Color.GREEN);
            }

        }
        return false;
    }
}
