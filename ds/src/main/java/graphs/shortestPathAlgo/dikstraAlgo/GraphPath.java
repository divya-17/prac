package graphs.shortestPathAlgo.dikstraAlgo;

public class GraphPath {

    Integer srcNode;
    Integer destNode;
    Integer weight;

    public GraphPath(Integer srcNode, Integer destNode, Integer weight) {
        this.srcNode = srcNode;
        this.destNode = destNode;
        this.weight = weight;
    }

    public Integer getSrcNode() {
        return srcNode;
    }

    public void setSrcNode(Integer srcNode) {
        this.srcNode = srcNode;
    }

    public Integer getDestNode() {
        return destNode;
    }

    public void setDestNode(Integer destNode) {
        this.destNode = destNode;
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
                ", destNode=" + destNode +
                ", weight=" + weight +
                '}';
    }
}
