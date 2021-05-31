package datastructure.binarytree.summation;

import java.util.ArrayList;
import java.util.List;

public class KPathBinaryTree {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Node root = new Node(1);
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

    public static void printKPath(Node root, int k) {

        printKPathUtil(root,  k);
    }

    public static void printKPathUtil(Node root, int k) {
        if (root == null)
            return;
        list.add(root.data);
        printKPathUtil(root.left, k);
        printKPathUtil(root.right, k);
        int f = 0;
        for (int j = list.size()-1; j >=0; j--) {
            f += list.get(j);
            if (f == k) {
                for (int i = j; i < list.size(); i++)
                    System.out.print(list.get(i)+" ");
                System.out.println();
            }


        }
        list.remove(list.size()-1);

    }
}
