package practice.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

    static class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data= data;
            this.left = null;
            this.right = null;
        }
    }

   static Node root;

    private static void reverseLevelOrder()
    {
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> st = new Stack<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            while(!queue.isEmpty())
            {
                Node temp = queue.poll();
                st.push(temp);
                if(temp.right != null)
                    queue.add(temp.right);
                if(temp.left != null)
                    queue.add(temp.left);
            }

        }

        while(!st.isEmpty())
            System.out.print(st.pop().data+" ");
    }
    public static void main(String[] args) {

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        reverseLevelOrder();
    }
}
