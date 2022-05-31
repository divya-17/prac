package binarySearchTree;

/*
Values to be inserted: [8, 3, 6, 10, 4, 7, 1]
 */
public class MainApp {

    public static void main(String[] args) {

        BSTApp app = new BSTApp();
        Node rootNode = null;

        // Create Binary -Tree
        rootNode = app.insert(rootNode, 8);
        rootNode = app.insert(rootNode, 3);
        rootNode = app.insert(rootNode, 6);
        rootNode = app.insert(rootNode, 10);
        rootNode = app.insert(rootNode, 4);
        rootNode = app.insert(rootNode, 7);
        rootNode = app.insert(rootNode, 1);

        System.out.println(rootNode);
    }
}
