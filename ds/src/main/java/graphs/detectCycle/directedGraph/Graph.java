package graphs.detectCycle.directedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Graph {


    private List<List<Vertex>>  adjList = new ArrayList<>();
    private boolean[] visited;
    private boolean cycleDetected = false;

    private Stack<Integer> graphCyclePath;

    public Graph(int numVertex){
        for(int i=0; i < numVertex; i++){
            adjList.add(new ArrayList<>());
        }
        visited = new boolean[numVertex];
        graphCyclePath = new Stack<>();
    }

    public List<List<Vertex>> getAdjList() {
        return adjList;
    }

    public boolean[] getVisited() {
        return visited;
    }

    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }

    public void setAdjList(List<List<Vertex>> adjList) {
        this.adjList = adjList;
    }

    public Stack<Integer> getGraphCyclePath() {
        return graphCyclePath;
    }

    public void addEdge(Vertex v, Vertex edge){

        int index = Integer.parseInt(v.getCh().toString());
        List<Vertex> existingList = adjList.get(index);
        existingList.add(edge);

    }


    public boolean detectCycle(int strtIndex){

        if(visited[strtIndex]) {
            System.out.println("Cycle detected");
            cycleDetected = true;
            return true;
        }
        else {
            visited[strtIndex] = true;
            graphCyclePath.push(strtIndex);
        }
        List<Vertex> joiningVertex = adjList.get(strtIndex);

        if(joiningVertex.size() == 0){
            visited[strtIndex] = false;
            graphCyclePath.pop();
            return false;
        }
        for(Vertex elem: joiningVertex){
            if(!cycleDetected){
                detectCycle(Integer.parseInt(elem.getCh().toString()));
            }
            else break;
        }
        if(!cycleDetected) {
            visited[strtIndex] = false;
            graphCyclePath.pop();
            return false;
        }
        return true;
    }

}
