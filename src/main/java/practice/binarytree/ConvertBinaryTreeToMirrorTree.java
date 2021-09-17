package practice.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertBinaryTreeToMirrorTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    private void mirror() {
        mirror(root);
    }

    private Node mirror(Node node) {
        if (node == null)
            return null;

        Node left = mirror(node.left);
        Node right = mirror(node.right);


        node.left = right;
        node.right = left;
        return node;
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    private void iterative() {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while (que.size() > 0) {
            Node cur = que.remove();
            Node temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

            if (cur.left != null)
                que.add(cur.left);
            if (cur.right != null)
                que.add(cur.right);
        }
    }

    public static void main(String[] args) {
        ConvertBinaryTreeToMirrorTree tree = new ConvertBinaryTreeToMirrorTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :");
        tree.inOrder(tree.root);
        System.out.println("");

        /* convert tree to its mirror */
        tree.mirror(tree.root);

        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : ");
        tree.inOrder(tree.root);
        System.out.println();
        System.out.println(" iterative ");
        tree.iterative();

        tree.inOrder(tree.root);

    }
}
