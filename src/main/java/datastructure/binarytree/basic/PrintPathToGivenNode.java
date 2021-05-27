package datastructure.binarytree.basic;

import java.util.ArrayList;
import java.util.List;

public class PrintPathToGivenNode {
    Node root;

    public static void printPath(Node root, int x) {
        List<Integer> list = new ArrayList<>();
        boolean hasPath = printPathUtil(root, list, x);
        if (hasPath) {
            for (Integer ele : list) {
                System.out.print(ele + " ");
            }
        }
        else
            System.out.println(" no Path ");
    }

    public static boolean printPathUtil(Node root, List<Integer> list, int x) {
        if (root == null)
            return false;
        list.add(root.data);
        if (root.data == x)
            return true;

         if(printPathUtil(root.left,list,x)|| printPathUtil(root.right,list,x))
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
        int x = 5;
        printPath(root, x);

    }
}
