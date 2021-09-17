package practice.binarytree;

import java.util.ArrayList;
import java.util.List;

public class KSumPath {
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

    private static void printKPath(Node root,int k)
    {
        List<Integer> list = new ArrayList<>();
        pathUtil(root,k,list);
    }
    private static void pathUtil(Node root,int k,List<Integer> list)
    {
        if(root == null)
            return;

        list.add(root.data);

        int sum =0;

        for(int i=list.size()-1;i>=0;i--)
        {
            sum += list.get(i);
            if(sum == k)
            {
                for(int j= list.size()-1;j>=i;j--)
                    System.out.print(list.get(j)+" ");
                System.out.println();
            }


        }

        pathUtil(root.left,k,list);
        pathUtil(root.right,k,list);
        list.remove(list.size()-1);


    }

    public static void main(String[] args) {
         root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);

        int k = 5;
        printKPath(root, k);
    }
}
