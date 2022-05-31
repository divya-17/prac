package binaryTrees.Ques;

import LLD.DesignPatterns.statePattern.NoCardATMState;
import binarySearchTree.BSTApp;
import binaryTrees.createTree.App;
import binaryTrees.createTree.BST;
import binaryTrees.createTree.Node;

import java.util.*;

/*
Given a binary tree and a target node, find all nodes at distance k from the target node.
 */
public class FindNodesAtKDistance {

    private static List<Integer> resultList  = new ArrayList<>();
    private static Boolean targetNodeFound = false;

    private static Stack<Node> ancestorNodes;
    private static Map<Node,Integer> ancestorNodeDistanceMap;
    
    public static void main(String[] args) {

        App app = new App();
        Node rootNode = app.getBSTTree1();
        ancestorNodeDistanceMap = new HashMap<>();
        Integer targetNodeData = 6;
        
        int k =3;
        int count = k;

        Node targetNode = getAllAncestorNodesToTargetNode(rootNode,targetNodeData,new Stack<Node>());
        System.out.println("Ancestor nodes "+ancestorNodes);
        System.out.println("Target Node "+targetNode);

        int distance = 1;
        if(ancestorNodes.size() >= count ){
            while (!ancestorNodes.isEmpty()){
                Node currNode = ancestorNodes.pop();
                count--;
                if(count == 0) resultList.add(currNode.getData());
            }
        }

        else{
            while (!ancestorNodes.isEmpty()){
                Node currNode = ancestorNodes.pop();
                ancestorNodeDistanceMap.put(currNode,distance);
                distance++;
            }
            System.out.println(ancestorNodeDistanceMap);
            for(Map.Entry<Node,Integer> entry: ancestorNodeDistanceMap.entrySet()){
                System.out.println("Node "+entry.getKey().getData());
                System.out.println("Distance "+(k-entry.getValue()));
                getAllNodesAtDistance(entry.getKey(),k-entry.getValue());
            }

        }
        //getAllNodesAtDistance(targetNode,k);

        System.out.println(resultList);
        
    }

    private static Node getAllAncestorNodesToTargetNode(Node rootNode, Integer targetNodeData, Stack<Node> tempStack) {

        if(rootNode == null){
            return null;
        }
        if(rootNode.getData() == targetNodeData){
            ancestorNodes = (Stack<Node>)tempStack.clone();
            targetNodeFound=true;
            return rootNode;
        }

        tempStack.add(rootNode);
        Node node1 = getAllAncestorNodesToTargetNode(rootNode.getLeftNode(),targetNodeData,tempStack);
        if(node1 != null && targetNodeFound){
            return node1;
        }
        Node node2 =getAllAncestorNodesToTargetNode(rootNode.getRightNode(),targetNodeData,tempStack);
        if(node2 != null && targetNodeFound){
            return node2;
        }
        tempStack.pop();

       return null;
    }


    private static void getAllNodesAtDistance(Node rootNode, int k) {

        if(rootNode == null || k < 0){
            return;
        }
        else if(k == 0){
            resultList.add(rootNode.getData());
            return;
        }
        getAllNodesAtDistance(rootNode.getLeftNode(),k-1);
        getAllNodesAtDistance(rootNode.getRightNode(),k-1);

    }
}
