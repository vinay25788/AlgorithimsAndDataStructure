package practice.binarytree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node root;


    private static void rootToLeaf()
    {
        List<Integer> list = new ArrayList<>();
        util(root,list);
    }
    private static void util(Node node,List<Integer> list)
    {
        if(node  == null)
            return;
        list.add(node.data);
        if(node.left == null && node.right == null)
        {
            System.out.println(list);
            list.remove(list.size()-1);
            return;
        }
        util(node.left,list);
        util(node.right,list);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

     rootToLeaf();
    }
}
