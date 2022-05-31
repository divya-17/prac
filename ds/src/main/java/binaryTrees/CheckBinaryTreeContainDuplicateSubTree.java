package binaryTrees;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

import java.util.HashMap;
import java.util.Map;

/*
IMP:
https://www.youtube.com/watch?v=_j7yb_nWFO8&list=PLDdcY4olLQk1-yJxgljSQ4ykbI2Bw1CqS&index=18
 */
public class CheckBinaryTreeContainDuplicateSubTree {


    private static Boolean isDuplicateTreePresent = false;
    private static Map<String,Integer> subTreeStrMap = new HashMap<>();

    public static void main(String[] args) {

        App app = new App();

        Node rootNode = app.getDuplicateSubTreeNode();
        populateSubTreeMap(rootNode);

        System.out.println(subTreeStrMap);
        System.out.println("Result "+isDuplicateTreePresent);
    }

    private static String populateSubTreeMap(Node rootNode) {

        if(rootNode == null) return "$";
        if(rootNode.getLeftNode() == null && rootNode.getRightNode() == null) return String.valueOf(rootNode.getData());

        String leftSubTreeStr = populateSubTreeMap(rootNode.getLeftNode());
        String rightSubTreeStr = populateSubTreeMap(rootNode.getRightNode());

        String finalStr = String.valueOf(rootNode.getData())+leftSubTreeStr+rightSubTreeStr;

        if(!subTreeStrMap.containsKey(finalStr)){
            subTreeStrMap.put(finalStr,1);
        }
        else{
            isDuplicateTreePresent = true;
            subTreeStrMap.put(finalStr,subTreeStrMap.get(finalStr)+1);
        }
        return finalStr;
    }

}
