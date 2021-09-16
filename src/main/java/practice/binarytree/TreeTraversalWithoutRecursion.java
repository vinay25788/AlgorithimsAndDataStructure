package practice.binarytree;

import java.util.Stack;

public class TreeTraversalWithoutRecursion {
    static class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
     static Stack<Node> st = new Stack<>();
    static Node root;
    public static void traversal()
    {
        if(root == null)
            return;

        Node temp = root;

        while(temp != null || st.size()>0)
        {
            while(temp != null )
            {
                st.push(temp);
                temp = temp.left;
            }
            temp = st.pop();
            System.out.print(temp.data+" ");
            temp = temp.right;
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
