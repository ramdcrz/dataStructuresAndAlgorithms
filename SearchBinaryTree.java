package dataStructuresAndAlgorithms;

public class SearchBinaryTree {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;

    public SearchBinaryTree() {
        root = null;
    }

    public boolean searchNode(Node temp, int value) {
        if (temp == null) {
            return false;
        }

        if (temp.data == value) {
            return true;
        }

        return searchNode(temp.left, value) || searchNode(temp.right, value);
    }

    public static void main(String[] args) {
        SearchBinaryTree bt = new SearchBinaryTree();
        bt.root = new Node(11);
        bt.root.left = new Node(8);
        bt.root.right = new Node(12);
        bt.root.left.left = new Node(78);
        bt.root.right.left = new Node(23);
        bt.root.right.right = new Node(36);

        boolean found = bt.searchNode(bt.root, 23);

        if (found) {
            System.out.println("Element is present in the binary tree.");
        } else {
            System.out.println("Element is not present in the binary tree.");
        }
    }
}
