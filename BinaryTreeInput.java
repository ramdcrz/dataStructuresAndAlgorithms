package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class BinaryTreeInput {

    static class Node {
        Node left, right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    static class BinaryTree {
        Node root;

        public BinaryTree() {
            root = null;
        }

        public void inOrderTraversal(Node node) {
            if (node == null) {
                return;
            }
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        System.out.print("Enter root node value: ");
        tree.root = new Node(scan.nextInt());

        System.out.print("Enter left child of root value: ");
        tree.root.left = new Node(scan.nextInt());

        System.out.print("Enter right child of root value: ");
        tree.root.right = new Node(scan.nextInt());

        System.out.print("Enter left child of left child of root value: ");
        tree.root.left.left = new Node(scan.nextInt());

        System.out.println("\nBinary tree:");
        tree.inOrderTraversal(tree.root);

        scan.close(); 
    }
}