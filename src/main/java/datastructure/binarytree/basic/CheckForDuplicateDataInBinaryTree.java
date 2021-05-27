package datastructure.binarytree.basic;

import java.util.HashSet;
import java.util.Set;

public class CheckForDuplicateDataInBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        if (checkDup(root))
            System.out.print("Yes");
        else
            System.out.print("No");

    }

    public static boolean checkDup(Node root)
    {
        Set<Integer> set = new HashSet<>();
        return checkDupUtil(root,set);
    }
    public static Boolean checkDupUtil(Node root,Set<Integer> set)
    {
        if(root == null)
            return false;
        if(set.contains(root.data))
            return true;
        set.contains(root.data);
        return checkDupUtil(root.left,set) && checkDupUtil(root.right,set);
    }
}
