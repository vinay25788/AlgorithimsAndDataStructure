package datastructure.binarytree.basic;

public class PrintNodeAtOddLevel {
    public static void main(String[] args) {
        Node root = new Node(1);
         root.left = new Node(2);
         root.left.left = new Node(3);
         root.right = new Node(4);
         root.right.right = new Node(5);
         root.right.right.right = new Node(6);
        printOddNode(root,true);

    }
    public static void printOddNode(Node root, boolean isOdd)
    {
        if(root == null)
            return;
        if(isOdd == true)
            System.out.print(root.data+" ");
        printOddNode(root.left, !isOdd);
        printOddNode(root.right, !isOdd);

    }
}
