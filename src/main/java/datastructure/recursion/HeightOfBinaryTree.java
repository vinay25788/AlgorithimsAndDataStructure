package datastructure.recursion;

public class HeightOfBinaryTree {

    static class Node
    {
        int val;
        Node left,rigth;

        Node(int val)
        {
            this.val = val;
            this.left = null;
            this.rigth = null;
        }

    }

    static Node root;
    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.left.rigth = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(5);
        System.out.println(height(root));
    }
    public static int height(Node root)
    {
        if(root == null)
            return 0;
        int l = height(root.left);
        int r= height( root.rigth);
        return 1+Math.max(l,r);
    }
}
