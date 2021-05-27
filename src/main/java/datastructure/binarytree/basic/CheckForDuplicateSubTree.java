package datastructure.binarytree.basic;

import java.util.HashSet;
import java.util.Set;

public class CheckForDuplicateSubTree {
    public static char MARKER='$';
    public static void main(String[] args) {
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');
        root.left.left = new Node('D');
        root.left.right = new Node('E');
        root.right.right = new Node('B');
        root.right.right.right = new Node('E');
        root.right.right.left= new Node('D');
        root.right.right.left.left = new Node('N');
        String str = checkDupSubTree(root);
        if(str.equals(""))
            System.out.print(" Yes ");
        else
            System.out.print(" No ");
    }

    public static String checkDupSubTree(Node root) {
        Set<String> set = new HashSet<>();
        return checkDupSubTreeUtil(root, set);
    }

    public static String checkDupSubTreeUtil(Node root, Set<String> subTree) {
        String s = "";
        if (root == null)
            return s+MARKER;
        String lstr = checkDupSubTreeUtil(root.left, subTree);
        if (lstr.equals(s))
            return s;
        String rstr = checkDupSubTreeUtil(root.right, subTree);
        if (rstr.equals(s))
            return s;
        s = s+ root.data + lstr + rstr;
        if (s.length() >= 3 && subTree.contains(s))
            return "";
        subTree.add(s);
        return s;

    }
}
