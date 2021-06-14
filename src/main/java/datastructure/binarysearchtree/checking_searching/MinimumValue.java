package datastructure.binarysearchtree.checking_searching;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class MinimumValue {
   static Node root;

    public static void insert(int data)
    {
        root = insertRec(root,data);
    }
    public static Node insertRec(Node root, int data)
    {

        if(root == null)
        {
            root = new Node(data);
            return root;
        }
        if(root.data < data)
        {
            root.right = insertRec(root.right,data);
        }
        else if(root.data> data)
        {
            root.left = insertRec(root.left,data);
        }
        return root;

    }/*
      public static Node insertRec(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (root.data < key)
            root.right = insertRec(root.right, key);
        else if (root.data > key)
            root.left = insertRec(root.left, key);

        return root;
    }
    */

    public static void getMin(Node root)
    {
        Node temp = root;
        while(temp.left != null)
        {
            temp = temp.left;
        }

        System.out.println(" Minimum " +temp.data);
    }

    public static void inOrder(Node root)
    {
        if(root != null)
        {
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {


        insert( 4);
        insert( 2);
        insert( 1);
        insert( 3);
        insert( 6);
        insert( 5);

        inOrder(root);
        System.out.println();

        getMin(root);
    }
}
