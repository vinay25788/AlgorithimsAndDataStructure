package practice.binarytree;

public class PrintNodeAtKDistance {

    static Node root;

    static class Node
    {
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    private static void printKDistanceNode(Node root,int k)
    {
        if(root == null || k<0)
            return;
        if(k == 0)
        {
            System.out.print(root.data+" ");
            return;
        }
        printKDistanceNode(root.left,k-1);
        printKDistanceNode(root.right ,k-1);
    }

    public static void main(String[] args) {
        PrintNodeAtKDistance tree = new PrintNodeAtKDistance();
        tree.root = new Node(-15);
        tree.root.left = new Node(5);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(-8);
        tree.root.left.right = new Node(1);
        tree.root.left.left.left = new Node(2);
        tree.root.left.left.right = new  Node(6);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(9);
        tree.root.right.right.right = new Node(0);
        tree.root.right.right.right.left = new Node(4);
        tree.root.right.right.right.right = new Node(-1);
        tree.root.right.right.right.right.left = new Node(10);

        printKDistanceNode(tree.root,3);
    }
}
