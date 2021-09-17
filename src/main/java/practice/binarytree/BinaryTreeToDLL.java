package practice.binarytree;

public class BinaryTreeToDLL {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    Node root;
    Node head;
    static Node prev = null;

    private  void binaryToDLL(Node cur)
    {
        if(cur == null)
            return;
        binaryToDLL(cur.left);
        if(prev == null)
            head = cur;
        else
        {
            cur.left = prev;
            prev.right = cur;
        }
        prev = cur;
        binaryToDLL(cur.right);
    }

    private  void printList(Node node)
    {
        if(node == null)
            return;
        Node cur = node;
        while(cur != null)
        {
            System.out.print(cur.data+" ");
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        BinaryTreeToDLL tree = new BinaryTreeToDLL();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        // convert to DLL
        tree.binaryToDLL(tree.root);

        // Print the converted List
        tree.printList(tree.head);
    }

}
