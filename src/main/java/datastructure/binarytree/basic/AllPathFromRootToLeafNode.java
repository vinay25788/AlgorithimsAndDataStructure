package datastructure.binarytree.basic;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromRootToLeafNode {
    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        printPathFromRootToNode(root);
    }
    public static void printPathFromRootToNode(Node root)
    {
        int[] path = new int[100];
        printPathFromRootToNodeUtil(root,path,0);
    }
    public static void printPathFromRootToNodeUtil(Node root, int[] path,int length )
    {
        if(root == null)
            return;
        path[length] = root.data;
        length++;
        if(root.left == null && root.right == null)
        {

            for(int i=0;i<length;i++)
                System.out.print(path[i]+" ");
            System.out.println();
            return;

        }
        else
        {
            printPathFromRootToNodeUtil(root.left,path,length);
            printPathFromRootToNodeUtil(root.right,path,length);
        }

    }

}
