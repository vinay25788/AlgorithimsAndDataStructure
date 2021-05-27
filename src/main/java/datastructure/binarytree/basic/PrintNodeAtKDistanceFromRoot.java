package datastructure.binarytree.basic;

public class PrintNodeAtKDistanceFromRoot {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.right = new Node(4);
        root.right.right = new Node(5);
        root.right.right.right = new Node(6);
        int k =2;
        printNodeAtKDistance(root,k);
    }
    public static void printNodeAtKDistance(Node root,int k)
    {
        if(root == null)
            return;
        if(k == 0)
        {
            System.out.print(root.data+" ");
            return;
        }
        else{
            printNodeAtKDistance(root.left,k-1);
            printNodeAtKDistance(root.right,k-1);
        }
    }
}
