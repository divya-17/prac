package graphs.MST.kruskalsAlgo;

public class GraphPath {

    private Integer srcNode;
    private Integer dstNode;
    private Integer weight;

    public GraphPath(Integer srcNode, Integer dstNode, Integer weight) {
        this.srcNode = srcNode;
        this.dstNode = dstNode;
        this.weight = weight;
    }

    public Integer getSrcNode() {
        return srcNode;
    }

    public void setSrcNode(Integer srcNode) {
        this.srcNode = srcNode;
    }


    public Integer getDstNode() {
        return dstNode;
    }

    public void setDstNode(Integer dstNode) {
        this.dstNode = dstNode;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "GraphPath{" +
                "srcNode=" + srcNode +
                ", dstNode=" + dstNode +
                ", weight=" + weight +
                '}';
    }
}
