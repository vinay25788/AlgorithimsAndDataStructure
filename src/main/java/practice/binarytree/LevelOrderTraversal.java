package practice.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    static class Node
    {
        int data;
        Node left, right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
                    this.right = null;
        }
    }
    static Node root;
    public static void traversal()
    {
        Queue<Node> queue = new LinkedList<>();


        queue.add(root);


        while(!queue.isEmpty())
        {
            Node temp = queue.poll();
            System.out.print(temp.data+" ");
            if(temp.left != null)
            {
                queue.add(temp.left);
            }
            if(temp.right != null)
            {
                queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        traversal();

    }
}
