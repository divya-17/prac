package graphs.MST.kruskalsAlgo;

public class Node {

    private Integer vertexValue;
    private Node parentNode;
    private Integer weight;
    private Node absoluteParentNode;



    public Node(Integer vertexValue, Node parentNode, Integer weight){

        this.vertexValue = vertexValue;
        this.parentNode = parentNode;
        this.weight = weight;
    }

    public Node(Integer vertexValue){
        this(vertexValue,null,0);
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

    public Node getAbsoluteParentNode() {
        return absoluteParentNode;
    }

    public void setAbsoluteParentNode(Node absoluteParentNode) {
        this.absoluteParentNode = absoluteParentNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "vertexValue=" + vertexValue +
                ", parentNode=" + parentNode +
                ", weight=" + weight +
                ", absoluteParentNode=" + absoluteParentNode +
                '}';
    }
}
