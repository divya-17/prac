package graphs.breadthFrstSearch;

/*

Queue data structure is used in BFS because it works on FIFO logic

 */
public class BFSApp {


    public static void main(String[] args) {

        GraphImpl graph = new GraphImpl();

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');

        graph.addEdge('A','B');
        graph.addEdge('B','C');
        graph.addEdge('A','C');
        graph.addEdge('C','D');
        graph.addEdge('D','E');
        graph.addEdge('A','D');
        graph.addEdge('E','F');


        //graph.showVertexMap();
        graph.bfs();
        System.out.println();

    }
}
