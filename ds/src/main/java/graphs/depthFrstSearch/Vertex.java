package graphs.depthFrstSearch;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String label;
    private Boolean isVisited;
    private List<Vertex> connectedVertices;

    public Vertex(String label){

        this.label = label;
        this.isVisited = false;
        connectedVertices = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getVisited() {
        return isVisited;
    }

    public void setVisited(Boolean visited) {
        isVisited = visited;
    }

    public List<Vertex> getConnectedVertices() {
        return connectedVertices;
    }

    public void setNeighbour(Vertex connectedVertex) {
        this.connectedVertices.add(connectedVertex);
    }

    public void display(){
        System.out.print("Vertex("+label+")=>");
    }
    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                ", isVisited=" + isVisited +
                ", connectedVertices=" + connectedVertices +
                '}';
    }
}
