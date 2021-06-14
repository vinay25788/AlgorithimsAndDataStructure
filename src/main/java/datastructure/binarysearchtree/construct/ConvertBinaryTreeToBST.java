package datastructure.binarysearchtree.construct;

import java.util.Arrays;

public class ConvertBinaryTreeToBST {

    public static Node root;
    public static int[] in;
    public static int index;
    public static int length;

    public static void main(String[] args) {
        root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(4);
        root.left.left = new Node(11);
        root.left.right = new Node(15);

        convertBTtoBST(root);
    }
    public static int countNode(Node root)
    {
        if(root == null)
            return 0;
        return countNode(root.left)+countNode(root.right)+1;
    }

    public static void findInOrder(Node root)
    {
        if(root == null)
        {
            return;
        }
        else {
            findInOrder(root.left);
            in[index++] = root.data;
            findInOrder(root.right);
        }

    }
    public static void printArray(Node root)
    {
        if(root == null)
            return;
        else
        {
            printArray(root.left);
            System.out.print(root.data+" ");
            printArray(root.right);
        }
    }
    public static void arrayToBST(Node root,int[] in)
    {
        if(root == null)
            return;
        arrayToBST(root.left,in);

        if(index<length) {
            root.data = in[index];
            index++;
        }
        arrayToBST(root.right,in);
    }
    public static void convertBTtoBST(Node root)
    {
        int n = countNode(root);
         in = new int[n];
        findInOrder(root);
        printArray(root);
        System.out.println("find array");
        System.out.println();
        for(int el:in)
            System.out.print(el+" ");
        Arrays.sort(in);
        arrayToBST(root, in);
        System.out.println();
        printArray(root);
    }
}
