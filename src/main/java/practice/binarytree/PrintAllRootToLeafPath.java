package practice.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllRootToLeafPath {

    static Node root;
    static class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data  = data;
            this.left = null;
            this.right = null;
        }
    }

    private static void printAllPath(Node root)
    {
        List<Integer> list  = new ArrayList<>();

        util(root,list);

    }
    private static void util(Node root,List<Integer> list)
    {
        if(root == null)
            return;
        list.add(root.data);
        if(root.left == null && root.right == null)
        {
            System.out.println(list);
           list.remove(list.size()-1);
            return;
        }

        util(root.left , list);
        util(root.right,list);
        list.remove(list.size()-1);
    }

   static void printTillGiven(Node givenNode)
    {
        List<Integer> list = new ArrayList<>();
        System.out.println(" given node path ");
        pathTillGivenNode(root,givenNode.data,list);
    }

    private static void pathTillGivenNode(Node root,int givenNode,List<Integer> list)
    {
        if(root == null)
        {
            return;
        }
        list.add(root.data);
        if(root.data == givenNode)
        {
            System.out.println(list);
            return;
        }
        pathTillGivenNode(root.left,givenNode,list);
        pathTillGivenNode(root.right,givenNode,list);
        list.remove(list.size()-1);

    }
    public static void main(String[] args) {

        root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(3);
        root.left.left = new Node(4);
        root.right = new Node(5);
        root.right.right = new Node(6);
        root.right.left = new Node(7);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);
        printAllPath(root);
        printTillGiven(  root.right.left.right);
    }
}
