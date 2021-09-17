package practice.binarytree;

public class IdenticalTree {

    static class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right  = null;
        }
    }


    static Node root;

    private static boolean areIdentical(Node root1,Node root2)
    {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.data == root2.data && areIdentical(root1.left,root2.left) && areIdentical(root1.right,root2.right))
            return true;
        return false;
    }

    public static void main(String[] args) {


        root = new Node(1);
        root.left = new Node(2);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.left.left = new Node(4);

        root.left.right = new Node(5);


        Node root2 = new Node(1);
        root2.left = new Node(2);

        root2.right = new Node(3);
        root2.right.left = new Node(6);
        root2.left.left = new Node(4);

        root2.left.right = new Node(9);

        System.out.println(areIdentical(root,root2));
    }
}
