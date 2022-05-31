package binaryTrees.Ques;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

import java.util.ArrayList;
import java.util.List;

public class LeftAndRightViewTree {


    private static List<Node> leftViewResult = new ArrayList<>();
    private static List<Node> rightViewResult = new ArrayList<>();

    public static void main(String[] args) {

        App app = new App();
        Node rootNode = app.getSkewedTreeForTreeView();

        leftViewResult.add(rootNode);
        rightViewResult.add(rootNode);

        getLeftView(rootNode,0);
        getRightView(rootNode,0);

        System.out.println("Tree Left View: "+leftViewResult);
        System.out.println("Tree Right View: "+rightViewResult);

    }

    private static void getRightView(Node rootNode,int level){

        if(rootNode == null) return;


        if(level >= rightViewResult.size()){
            rightViewResult.add(rootNode);
        }
        getRightView(rootNode.getRightNode(),level+1);
        getRightView(rootNode.getLeftNode(),level+1);

    }
    private static void getLeftView(Node rootNode, int level) {

        if(rootNode == null) return;


        if(level >= leftViewResult.size()){
            leftViewResult.add(rootNode);
        }

        getLeftView(rootNode.getLeftNode(),level+1);
        getLeftView(rootNode.getRightNode(),level+1);
    }
}
