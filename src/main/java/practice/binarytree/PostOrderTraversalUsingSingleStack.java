package practice.binarytree;

import java.util.Stack;

public class PostOrderTraversalUsingSingleStack {
    static Node root;

    static class Node {
        int data;
        Node left, right;
        boolean rightTraversed;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static void postOrder(Node node) {
        if (node == null)
            return;
        Stack<Node> st = new Stack<>();
        st.push(node);
        node = node.left;
        while (!st.isEmpty()) {
            while (node != null && !node.rightTraversed) {
                st.push(node);
                node = node.left;
            }

            if (node != null)
                System.out.print(node.data + " ");

            if (!st.isEmpty())
                node = st.pop();
            if (!node.rightTraversed && node.right != null) {
                node.rightTraversed = true;
                st.push(node);
                node = node.right;
            }

        }


    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        postOrder(root);
    }
}
