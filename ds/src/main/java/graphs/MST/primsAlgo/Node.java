package graphs.MST.primsAlgo;

public class Node {

    Integer vertexValue;
    Node parentNode;
    Integer weight;
    Boolean isIncludedInMSTSet;

    public Node(Integer vertexValue, Node parentNode, Integer weight){

        this.vertexValue = vertexValue;
        this.parentNode = parentNode;
        this.weight = weight;
    }

    public Boolean getIncludedInMSTSet() {
        return isIncludedInMSTSet;
    }

    public void setIncludedInMSTSet(Boolean includedInMSTSet) {
        isIncludedInMSTSet = includedInMSTSet;
    }

    public Node(Integer vertexValue, Node parentNode){
        this(vertexValue,parentNode,Integer.MAX_VALUE);
    }

    public Node(Integer vertexValue){
        this(vertexValue,null,Integer.MAX_VALUE);
    }




    public Integer getVertexValue() {
        return vertexValue;
    }

    public void setVertexValue(Integer vertexValue) {
        this.vertexValue = vertexValue;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "V=" + vertexValue +
                ", PN=" + parentNode +
                ", W=" + weight +
                ", MSTSetIncl=" + isIncludedInMSTSet +
                '}';
    }
}
