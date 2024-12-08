package dataStructuresAndAlgorithms;

public class BinaryTreeInsert {

    public static void main(String[] args) {
        new BinaryTreeInsert().run();
    }

    static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public void run() {
        Node rootNode = new Node(25);
        System.out.println("Building tree with root value " + rootNode.value);
        System.out.println("================================");
        insert(rootNode, 11);
        insert(rootNode, 15);
        insert(rootNode, 16);
        insert(rootNode, 23);
        insert(rootNode, 79);
    }

    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println(" Inserted " + value + " to left of Node " + node.value);
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println(" Inserted " + value + " to right of Node " + node.value);
                node.right = new Node(value);
            }
        }
    }
}
