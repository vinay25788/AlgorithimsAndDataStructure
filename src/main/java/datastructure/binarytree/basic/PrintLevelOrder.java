package datastructure.binarytree.basic;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelOrder {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        printLevelOrder(root);
    }
    public static void printLevelOrder(Node root)
    {
        Queue<Node> que = new LinkedList<>();
        Node cur = root;
        que.add(cur);
        while(!que.isEmpty())
        {
            Node temp = que.remove();
            System.out.print(temp.data+" ");
            if(temp.left != null)
            {
                que.add(temp.left);
            }
            if(temp.right != null)
            {
                que.add(temp.right);
            }
        }
    }
}
