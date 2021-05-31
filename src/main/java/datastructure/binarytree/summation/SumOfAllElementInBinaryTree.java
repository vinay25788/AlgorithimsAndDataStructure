package datastructure.binarytree.summation;

class Node
{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class SumOfAllElementInBinaryTree {
    public static void inOrder(Node root)
    {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static int add(Node root)
    {
            if(root == null)
                return 0;
            return root.data+add(root.left)+add(root.right);

    }
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        System.out.println(add(root));

    }
}
