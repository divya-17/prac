package graphs.graphTraversal.adjMatrix;

import java.util.List;

public class Vertex {


    private Character vertexChar;

    public Vertex(Character ch){
        vertexChar = ch;
    }

    public Character getVertexChar() {
        return vertexChar;
    }

    public void setVertexChar(Character vertexChar) {
        this.vertexChar = vertexChar;
    }

    public void setNeighbours(List<Character> neighbours, boolean[][] adjMatrix){

        for(Character vertexChar: neighbours){
            //System.out.println("Matrix index is ("+(this.getVertexChar()-'A')+"),("+(vertexChar-'A')+")");
            adjMatrix[this.getVertexChar()-'A'][vertexChar-'A'] = true;
        }
    }
}
