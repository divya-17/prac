package graphs.shortestPathAlgo.bellmanFordAlgo;

public class Node {

    private Integer value;
    private Integer weight;
    private Integer parentNode;

    public Node(Integer value){

        this.value = value;
        this.weight = Integer.MAX_VALUE;
        this.parentNode = -1;
    }




}
