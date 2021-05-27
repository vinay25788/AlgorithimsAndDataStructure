package datastructure.binarytree.basic;

public class ConvertBinaryTreeIntoDoubleLinkedList {
    Node root;
    Node head;
    Node prev;

    void convertBinaryToDoubleLinkedList(Node root) {
        if (root == null)
            return;
        convertBinaryToDoubleLinkedList(root.right);
        root.right = head;
        if (head != null) {

            head.left = root;
        }
            head = root;
        convertBinaryToDoubleLinkedList(root.left);


    }

    void convertBinary2DoubleLinkedList(Node root)
    {
        if(root == null)
            return;
        convertBinaryToDoubleLinkedList(root.left);
        if(prev == null)
        {
            head = root;
        }
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertBinaryToDoubleLinkedList(root.right);
    }

    public void printList(Node head) {
        System.out.println(" double linked list ");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }

    public static void main(String[] args) {
        ConvertBinaryTreeIntoDoubleLinkedList tree = new ConvertBinaryTreeIntoDoubleLinkedList();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.right = new Node(4);
        tree.root.left.left = new Node(1);
        tree.root.right.right = new Node(8);
        tree.root.left.left.right = new Node(2);
        tree.root.left.left.left = new Node(0);
        tree.root.right.right.left = new Node(7);
        tree.root.right.right.right = new Node(9);

        tree.convertBinaryToDoubleLinkedList(tree.root);
        tree.printList(tree.head);
    }
}
