package practice.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderSpiralForm {
    static Node root;

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

    private static void printSpiralForm()
    {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while(! s1.isEmpty() || !s2.isEmpty())
        {
           while(!s1.isEmpty())
           {
               Node temp = s1.pop();
               System.out.print(temp.data+" ");
               if(temp.left != null)
                   s2.push(temp.left);
               if(temp.right != null)
                   s2.push(temp.right);
           }
           while(!s2.isEmpty())
           {
               Node temp = s2.pop();
               System.out.print(temp.data+" ");
               if(temp.right != null)
                   s1.push(temp.right);
               if(temp.left != null)
                   s1.push(temp.left);
           }
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);

        printSpiralForm();
    }
}
