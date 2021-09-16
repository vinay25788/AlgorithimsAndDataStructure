package practice.binarytree;


import java.util.List;

public class LeftVeiw {
    static Node root;
    static int maxLevel=0;

    static class Node {
        int data;
       Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static void leftVeiw(Node root) {
        System.out.print(root.data+" ");
        util(root, 0);
    }
    private static void util(Node root,int level)
    {
        if(root == null)
            return;
        if(level>maxLevel)
        {
            System.out.print(root.data+" ");
            maxLevel = level;
        }
        util(root.left,level+1);
        util(root.right,level+1);
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
        leftVeiw(root);
    }
}
