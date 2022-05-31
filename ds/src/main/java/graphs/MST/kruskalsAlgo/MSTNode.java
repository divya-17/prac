package graphs.MST.kruskalsAlgo;

public class MSTNode {

    private Integer nodeValue;
    private Integer parentNode;
    private Integer absoluteParentNode;
    private Integer rank;

    public MSTNode(Integer nodeValue){
        this.nodeValue = nodeValue;
        parentNode = -1;
        absoluteParentNode = -1;
        rank = 0;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(Integer nodeValue) {
        this.nodeValue = nodeValue;
    }

    public Integer getParentNode() {
        return parentNode;
    }

    public void setParentNode(Integer parentNode) {
        this.parentNode = parentNode;
    }

    public Integer getAbsoluteParentNode() {
        return absoluteParentNode;
    }

    public void setAbsoluteParentNode(Integer absoluteParentNode) {
        this.absoluteParentNode = absoluteParentNode;
    }

    @Override
    public String toString() {
        return "MSTNode{" +
                "nodeValue=" + nodeValue +
                ", parentNode=" + parentNode +
                ", absoluteParentNode=" + absoluteParentNode +
                '}';
    }
}
