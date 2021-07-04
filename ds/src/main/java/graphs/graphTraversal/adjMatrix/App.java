package graphs.graphTraversal.adjMatrix;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        Graph gf = new Graph(6,6);

        // Directed Graph:
        Vertex vertexA = gf.addVertex('A');
        Vertex vertexB = gf.addVertex('B');
        Vertex vertexC = gf.addVertex('C');
        Vertex vertexD = gf.addVertex('D');
        Vertex vertexE = gf.addVertex('E');
        Vertex vertexF = gf.addVertex('F');

        gf.addVertexNeighbours(vertexA,new ArrayList<>(Arrays.asList('B','C')));
        gf.addVertexNeighbours(vertexB,new ArrayList<>(Arrays.asList('D')));
        gf.addVertexNeighbours(vertexD,new ArrayList<>(Arrays.asList('E','F')));
        gf.addVertexNeighbours(vertexE,new ArrayList<>(Arrays.asList('B','C','F')));



        // Depth first search traversal
        System.out.println("<<<==== DFS =====>>>");
        gf.dfs(0);

        // Breadth first search traversal
        System.out.println("<<<==== BFS =====>>>");
        gf.bfs(0);


    }
}
