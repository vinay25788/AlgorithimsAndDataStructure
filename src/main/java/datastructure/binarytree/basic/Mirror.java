package datastructure.binarytree.basic;

import java.util.LinkedList;
import java.util.Queue;

public class Mirror {

    public static void mirror(Node root) {
        Queue<Node> que = new LinkedList<>();
        Node cur = root;
        que.add(cur);
        while (que.size() > 0) {
            Node temp = que.remove();
            Node t1 = temp.left;
            temp.left = temp.right;
            temp.right = t1;
            if (temp.left != null)
                que.add(temp.left);
            if (temp.right != null)
                que.add(temp.right);
        }
    }

    public static Node mirrorUsingRecursion(Node root)
    {
        if(root == null)
            return null;
        Node left = mirrorUsingRecursion(root.left);
        Node right = mirrorUsingRecursion( root.right);
        root.left = right;
        root.right = left;
        return root;


    }

    public static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        /* Print inorder traversal of the input tree */
        System.out.print("\n Inorder traversal of the"
                + " coned tree is \n");
        inOrder(root);

        /* Convert tree to its mirror */
        mirror(root);

        /* Print inorder traversal of the mirror tree */
        System.out.print("\n Inorder traversal of the " +
                "mirror tree is \n");
        inOrder(root);

        System.out.println(" mirror using recursion ");
        mirrorUsingRecursion(root);
        inOrder(root);

    }


}
