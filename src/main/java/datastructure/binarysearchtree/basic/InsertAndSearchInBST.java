package datastructure.binarysearchtree.basic;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class InsertAndSearchInBST {

    static Node root;

    public static void insert(int key) {
        root = insertRec(root, key);
    }

    public static Node insertRec(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (root.data < key)
            root.right = insertRec(root.right, key);
        else if (root.data > key)
            root.left = insertRec(root.left, key);

        return root;
    }

    public static void inOrder(Node root) {
        if (root == null)
            return;
        else {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        insert(8);
        insert(19);
        insert(30);
        insert(5);
        insert(9);
        inOrder(root);

    }
}
