package graphs;

import scala.Int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a graph, create another graph which is clone of the original one.
 */
public class CloneGraph {

    public static void main(String[] args) {

        Node[] nodeArr = new Node[100];
        Arrays.fill(nodeArr,null);


        Node rootNode = createGraph();

        Node cloneRootNode = createCloneOfGraph(rootNode,nodeArr);
    }

    private static Node createCloneOfGraph(Node rootNode,Node[] nodeArr) {
        Node copyRootNode;
        if(rootNode == null) return null;
        else {
            copyRootNode = new Node(rootNode.val);
            dfs(rootNode,copyRootNode,nodeArr);
        }
        return copyRootNode;
    }

    private static void dfs(Node rootNode, Node copyRootNode, Node[] nodeArr) {

        if(nodeArr[copyRootNode.getVal()] == null){
            nodeArr[copyRootNode.getVal()] = copyRootNode;
        }
        for(Node node: rootNode.getNeighbourNodes()){

            if(nodeArr[node.getVal()] == null){
                Node newCopyNode = new Node(node.getVal());
                copyRootNode.getNeighbourNodes().add(newCopyNode);
                dfs(node,newCopyNode,nodeArr);
            }

            else{
                copyRootNode.getNeighbourNodes().add(nodeArr[node.getVal()]);
            }
        }

    }


    private static Node createGraph() {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.setNeighbourNodes(new ArrayList<>(Arrays.asList(n2,n3)));
        n2.setNeighbourNodes(new ArrayList<>(Arrays.asList(n1,n3)));
        n3.setNeighbourNodes(new ArrayList<>(Arrays.asList(n1,n2)));

        return n1;
    }
}

class Node{

    int val;
    List<Node> neighbourNodes;


    public Node(){
        val = 0;
        neighbourNodes = new ArrayList<>();
    }

    public Node(int val){
        this.val = val;
        neighbourNodes = new ArrayList<>();
    }

    public Node(int val, List<Node> neighbourNodes){
        this.val = val;
        this.neighbourNodes = neighbourNodes;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<Node> getNeighbourNodes() {
        return neighbourNodes;
    }

    public void setNeighbourNodes(List<Node> neighbourNodes) {
        this.neighbourNodes = neighbourNodes;
    }


}
