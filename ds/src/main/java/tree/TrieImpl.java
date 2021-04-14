package tree;

import java.util.ArrayList;
import java.util.List;

/*

Data Structure that is used for faster searching , insertion, deletion etc.

 */
public class TrieImpl {


    public static void main(String[] args) {

        String testStr = "pqrst";


        String testStr1 = "pqru";

        TrieNode rootNode = new TrieNode();

        TrieNode pNode = rootNode.insert('p', false);
        TrieNode qNode = pNode.insert('q',false);
        TrieNode rNode = qNode.insert('r',false);
        TrieNode sNode = rNode.insert('s',false);
        TrieNode tNode = sNode.insert('t',true);



        TrieNode p1Node = rootNode.insert('p',false);
        TrieNode q1Node = p1Node.insert('q',false);
        TrieNode r1Node = q1Node.insert('r',false);
        TrieNode u1Node = r1Node.insert('u',true);

        System.out.println(rootNode);


        //        TrieNode qNode = rootNode.insert('q',false);
//        System.out.println(qNode);

        //        TrieNode rNode = qNode.insert('r',false);
//        TrieNode sNode = rNode.insert('s',false);
//        TrieNode tNode = sNode.insert('t',true);
//
//        System.out.println("Tree str created is ");
//        TrieNode rootNode = tree.getRootNode();
//        System.out.println("Number of children:"+rootNode.getChildrenNodes().size());
//
//        for(TrieNode node: rootNode.getChildrenNodes()){
//            System.out.println(node.getNodeChar());
//        }
    }

}


class Trie{

    TrieNode rootNode ;


    public Trie (){
        rootNode = new TrieNode();
    }



    public TrieNode insert(Character c, Boolean terminatingNode){
        return this.insert(c,terminatingNode);

    }

    public TrieNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(TrieNode rootNode) {
        this.rootNode = rootNode;
    }
}


class TrieNode{

    Character nodeChar;
    List<TrieNode> childrenNodes;
    Boolean terminatingNode;


    public TrieNode(){

        terminatingNode = false;
        nodeChar=null;
        childrenNodes = new ArrayList<>();
    }

    public TrieNode insert(Character c, Boolean terminatingNode) {

        if(this.getChildrenNodes().size()>0){

            for(TrieNode node: this.getChildrenNodes()){
                if(node.getNodeChar().equals(c)){
                    return node;
                }
            }
        }
        TrieNode childNode = new TrieNode();
        childNode.setNodeChar(c);
        childNode.setTerminatingNode(terminatingNode);
        childNode.setChildrenNodes(new ArrayList<TrieNode>());

        this.getChildrenNodes().add(childNode);
        return childNode;
    }

    public Boolean getTerminatingNode() {
        return terminatingNode;
    }

    public void setTerminatingNode(Boolean terminatingNode) {
        this.terminatingNode = terminatingNode;
    }

    public Character getNodeChar() {
        return nodeChar;
    }

    public void setNodeChar(Character nodeChar) {
        this.nodeChar = nodeChar;
    }

    public List<TrieNode> getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(List<TrieNode> childrenNodes) {
        this.childrenNodes = childrenNodes;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "nodeChar=" + nodeChar +
                ", childrenNodes=" + childrenNodes +
                ", terminatingNode=" + terminatingNode +
                '}';
    }
}

