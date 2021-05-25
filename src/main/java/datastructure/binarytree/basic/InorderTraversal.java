package datastructure.binarytree.basic;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class InorderTraversal {

    public static void inorder(Node root)
    {
        if(root != null)
        {
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        inorder(root);


    }
}
