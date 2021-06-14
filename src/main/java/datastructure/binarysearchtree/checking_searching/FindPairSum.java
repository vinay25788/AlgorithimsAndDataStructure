package datastructure.binarysearchtree.checking_searching;

import java.util.HashSet;
import java.util.Set;

public class FindPairSum {

    static Node root;

    public static void insert(int data)
    {
        root = insertRec(root,data);
    }
    public static Node insertRec(Node node,int data)
    {
        if(node == null)
            return new Node(data);
        if(data<node.data)
            node.left = insertRec(node.left,data);
        else if(data>node.data)
            node.right = insertRec(node.right,data);
        return node;
    }

    public static void findPair(Node root,int sum)
    {

        Set<Integer> set = new HashSet<>();
        findPairUtil(root,sum,set);
    }
    public static boolean findPairUtil(Node root,int sum,Set<Integer> set)
    {
        if(root == null)
            return false;
        if(findPairUtil(root.left,sum,set))
            return true;
        if(set.contains(sum- root.data))
        {
            System.out.println("pair found "+ (sum-root.data)+" "+root.data);
            return true;
        }
        else
            set.add(root.data);


        return findPairUtil(root.right,sum,set);
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
        insert(5);
        insert(3);
        insert(2);
        insert(4);
        insert(11);
        insert(8);
        inOrder(root);
        findPair(root,10);
    }
}
