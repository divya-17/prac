package graphs;

/*

Given a unweighted graph (grph with all edges having the same weightage), find the shortest
path between source and destination node.

 */

import graphs.breadthFrstSearch.GraphImpl;
import graphs.breadthFrstSearch.VertexImpl;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathInGraph {

    public static void main(String[] args) {

        GraphImpl graph = new GraphImpl();


        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        graph.addEdge('A', 'B');
        graph.addEdge('A', 'G');
        graph.addEdge('A', 'D');
        graph.addEdge('B', 'C');
        graph.addEdge('C', 'F');
        graph.addEdge('D', 'E');
        graph.addEdge('E', 'F');
        graph.addEdge('F', 'G');

        // Show graph

        graph.bfs();

        char sourceLabel = 'A';
        char destinationLabel = 'G';

        int shortestDistance = getShortestPath(graph, sourceLabel, destinationLabel);

        System.out.println(shortestDistance);

    }

    private static int getShortestPath(GraphImpl graph, char sourceLabel, char destinationLabel) {


        List<Integer> currentDepth = new ArrayList<>();
        List<Integer> nextDepth = new ArrayList<>();


        currentDepth.add(sourceLabel - 'A');
        int shortestDistance = 0;

        while (!currentDepth.isEmpty()) {
            for (Integer indx : currentDepth) {

                List<VertexImpl> connectedVertices = graph.getVertexMap().get(graph.getVertexList().get(indx));

                for (VertexImpl vertex : connectedVertices) {
                    nextDepth.add(vertex.getLabel() - 'A');

                }
            }
            currentDepth = nextDepth;
            nextDepth.clear();
            shortestDistance++;

            for (Integer indx : currentDepth) {

                if (graph.getVertexList().get(indx).getLabel() == destinationLabel) {
                    return shortestDistance;
                }
            }
        }

        return -1;

    }
}
