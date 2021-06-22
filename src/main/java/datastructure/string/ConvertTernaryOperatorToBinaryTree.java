package datastructure.string;

import datastructure.binarytree.basic.ConvertBinaryTreeIntoDoubleLinkedList;
import datastructure.binarytree.basic.ConvertTernaryExpression;

import javax.swing.text.IconView;

public class ConvertTernaryOperatorToBinaryTree {
    class Node
    {
        char data;
        Node left,right;
        Node(char data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {


        String st= "a?b?c:d:e";
        ConvertTernaryOperatorToBinaryTree obj = new ConvertTernaryOperatorToBinaryTree();
      Node root = obj. covert(st,0);
        preOrder(root);
    }
    public static void preOrder(Node root)
    {
        if(root != null)
        {
            System.out.print(root.data+" ");
            preOrder(root.left);

            preOrder(root.right);
        }
    }
    public  Node covert(String st,int i)
    {
        if(i>=st.length())
            return null;
        Node root = new Node(st.charAt(i));
        i++;
        if(i<st.length() && st.charAt(i)=='?')
            root.left = covert(st,i+1);
        else if(i<st.length())
            root.right = covert(st,i+1);
        return root;

    }

}
