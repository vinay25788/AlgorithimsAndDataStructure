package datastructure.binarytree.basic;

public class PrintBoundary {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(7);

        printBoundary(root);
    }
    public static void printBoundary(Node root)
    {
        if(root == null)
            return;
        System.out.print(root.data+" ");
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }

    public static void printRightBoundary(Node root)
    {
        if(root == null)
            return;
        if(root.right!= null)
        {
            printRightBoundary(root.right);
            System.out.print(root.data+" ");

        }
        else if (root.left != null)
        {
            printRightBoundary(root.left);
            System.out.print(root.data +" ");
        }
    }

    public static void printLeaves(Node root)
    {
        if(root == null)
            return;
        printLeaves(root.left);
        if(root.left == null && root.right == null)
            System.out.print(root.data+" ");
        printLeaves(root.right);
    }

    public static void printLeftBoundary(Node root)
    {
        if(root == null)
            return;
        if(root.left != null )
        {
            System.out.print(root.data+" ");
            printLeftBoundary(root.left);
        }
        else if(root.right != null)
        {
            System.out.print(root.right+" ");
            printLeftBoundary(root.right);
        }
    }
}
