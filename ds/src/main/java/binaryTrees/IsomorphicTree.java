package binaryTrees;

import binaryTrees.createTree.App;
import binaryTrees.createTree.Node;

/*
https://www.geeksforgeeks.org/tree-isomorphism-problem/
 */
public class IsomorphicTree {

    public static void main(String[] args) {

        App app = new App();

        Node tree1 = app.getIsomorphicTree1();
        Node tree2 = app.getIsomorphicTree2();

        Boolean result = isIsomorphicTree(tree1,tree2);
        System.out.println(result);
    }

    private static Boolean isIsomorphicTree(Node tree1, Node tree2) {

        if(tree1 == null && tree2 == null) return true;

        if((tree1 != null && tree2 == null) || (tree1 == null && tree2 != null)) return false;

        if(tree1.getData() != tree2.getData()) return false;

        Boolean ans1 = isIsomorphicTree(tree1.getLeftNode(),tree2.getRightNode()) && isIsomorphicTree(tree1.getRightNode(),tree2.getLeftNode());
        Boolean ans2 = isIsomorphicTree(tree1.getLeftNode(),tree2.getLeftNode()) && isIsomorphicTree(tree1.getRightNode(),tree2.getRightNode());

        return ans1 || ans2;
    }
}
