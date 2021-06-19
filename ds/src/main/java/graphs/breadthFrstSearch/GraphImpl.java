package graphs.breadthFrstSearch;

import java.util.*;

public class GraphImpl {


    private Map<VertexImpl,LinkedList<VertexImpl>> vertexMap;
    private LinkedList queue;
    private List<VertexImpl> vertexList;

    public GraphImpl() {

        vertexMap = new HashMap<>();
        queue = new LinkedList();
        vertexList = new ArrayList<>();
    }

    public void addVertex(char label) {

        VertexImpl vertex = new VertexImpl(label);
        vertexMap.put(vertex,new LinkedList<>());
        vertexList.add(vertex);
    }

    public void addEdge(char frstLabel, char secondLabel) {

        for(Map.Entry<VertexImpl,LinkedList<VertexImpl>> vertex: vertexMap.entrySet()){

            if(vertex.getKey().getLabel() ==frstLabel){
                vertex.getValue().add(vertexList.get(secondLabel-'A'));
            }

            if(vertex.getKey().getLabel() ==secondLabel){
                vertex.getValue().add(vertexList.get(frstLabel-'A'));
            }

        }
    }

    public void showVertexMap(){

        for(Map.Entry<VertexImpl,LinkedList<VertexImpl>> vertex: vertexMap.entrySet()){

            System.out.println("KEY =>"+vertex.getKey().getLabel());
            for(VertexImpl vertex1: vertex.getValue()) {
                System.out.print(" VALUE =>" +vertex1.getLabel());
            }
            System.out.println();
        }
    }

    public void bfs() {
//
//        for(int i=0; i < ajMatrx.length; i++){
//            for(int j=0; j < ajMatrx[0].length;j++){
//                System.out.print(ajMatrx[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//        for(int  i =0; i < vertexList.length; i++){
//            System.out.print(vertexList[i].getLabel()+" ");
//        }

        queue.add(0);
        VertexImpl startVertex = vertexList.get(0);
        startVertex.setVisited(true);

        while (!queue.isEmpty()) {

            Integer vertexIndex = (Integer) queue.pop();
            vertexList.get(vertexIndex).display();

            List<VertexImpl> connectedVertex = getConnectedVertex(vertexList.get(vertexIndex));


            for(VertexImpl vertex: connectedVertex){
                queue.add(vertex.getLabel()-'A');
                vertexList.get(vertex.getLabel()-'A').setVisited(true);
            }
        }

    }

    public List<VertexImpl> getVertexList() {
        return vertexList;
    }

    public Map<VertexImpl, LinkedList<VertexImpl>> getVertexMap() {
        return vertexMap;
    }

    private List<VertexImpl> getConnectedVertex(VertexImpl vertex) {


        List<VertexImpl> nonvisitedNeighbours = new LinkedList<>();

        for(VertexImpl connVertices: vertexMap.get(vertex)){
            if(!connVertices.getVisited()){
                nonvisitedNeighbours.add(connVertices);
            }
        }

        return nonvisitedNeighbours;
    }
}
