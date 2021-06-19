package graphs.depthFrstSearch;

public class App {


    public static void main(String[] args) {


        Vertex vertex1 = new Vertex("1");
        Vertex vertex2 = new Vertex("2");
        Vertex vertex3 = new Vertex("3");
        Vertex vertex4 = new Vertex("4");
        Vertex vertex5 = new Vertex("5");


        vertex1.setNeighbour(vertex2);
        vertex1.setNeighbour(vertex3);
        vertex3.setNeighbour(vertex4);
        vertex4.setNeighbour(vertex5);

        DfsGraph graph = new DfsGraph();

        graph.dfs(vertex1);
    }
}
