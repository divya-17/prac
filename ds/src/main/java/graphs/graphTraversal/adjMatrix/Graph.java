package graphs.graphTraversal.adjMatrix;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {


    private boolean[][] adjMatrix;
    private char [] alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private boolean[] dfsVisited;
    private boolean [] bfsVisited;
    private Queue<Integer> indexQueue = new LinkedList();


    public Graph(int numVertex, int numEdges){

        adjMatrix = new boolean[numVertex][numEdges];
        dfsVisited = new boolean[numVertex];
        bfsVisited = new boolean[numVertex];
    }


    public boolean[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(boolean[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public Vertex addVertex(Character ch) {
        Vertex vertex = new Vertex(ch);
        return vertex;
    }

    public void addVertexNeighbours(Vertex vertex,List<Character> characters){
        vertex.setNeighbours(characters,adjMatrix);
    }


    public void dfs(int startIndex){

        dfsVisited[startIndex] =true;
        System.out.println(alphabets[startIndex]);

        for(int i=0 ; i < adjMatrix.length; i++){
            if(adjMatrix[startIndex][i] && !dfsVisited[i]){
                dfs(i);
            }
        }
    }

    public void bfs(int startIndex) {

        indexQueue.add(startIndex);
        bfsVisited[startIndex] = true;

        while (!indexQueue.isEmpty()){
            int currIndex = indexQueue.poll();
            System.out.println(alphabets[currIndex]);
            for(int i=0; i < adjMatrix[currIndex].length; i++){
                if(adjMatrix[currIndex][i] && !bfsVisited[i]){
                    indexQueue.add(i);
                    bfsVisited[i] = true;
                }
            }
        }
    }
}
