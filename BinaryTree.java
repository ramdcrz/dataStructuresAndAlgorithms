package dataStructuresAndAlgorithms;

public class BinaryTree {
    Node root;

    public void traverseTree(Node node) {
        if (node != null) {
            traverseTree(node.left);
            System.out.print(" " + node.key);
            traverseTree(node.right);
        }
    }
}
