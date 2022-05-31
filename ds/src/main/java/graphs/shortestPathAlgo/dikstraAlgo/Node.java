package graphs.shortestPathAlgo.dikstraAlgo;

public class Node {

    Integer value;
    Integer weight;
    Integer parentNode;
    Boolean isProcessed;

    public Node(Integer value){

        this.value = value;
        this.weight = Integer.MAX_VALUE;
        this.parentNode = -1;
        this.isProcessed = false;
    }
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getParentNode() {
        return parentNode;
    }

    public void setParentNode(Integer parentNode) {
        this.parentNode = parentNode;
    }

    public Boolean getProcessed() {
        return isProcessed;
    }

    public void setProcessed(Boolean processed) {
        isProcessed = processed;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", weight=" + weight +
                ", parentNode=" + parentNode +
                ", isProcessed=" + isProcessed +
                '}';
    }
}
