package datastructure.binarytree.lowest_common_ancestor;

import java.util.ArrayList;
import java.util.List;

public class PrintPathFromRootToGivenNode {

    static List<Integer> list;
    public static void printPath(Node root,int a)
    {
         list = new ArrayList<>();
        printPathUtil(root,a);
        System.out.println(list);
    }
    public static boolean printPathUtil(Node root, int a)
    {
        if(root == null)
            return false;
        list.add(root.data);
        if(root.data == a)
        {
            return true;
        }
        if(printPathUtil(root.left,a) || printPathUtil(root.right ,a))
            return true;

        list.remove(list.size()-1);
        return false;


    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        printPath(root, 4);


    }
}
