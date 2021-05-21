package datastructure.linkelist.singleLinkedlist;

public class FlattenLinkedList {

    class Node {
        int data;
        Node down, right;

        Node(int data) {
            this.data = data;
            this.down = null;
            this.right = null;
        }
    }

    Node head;

    public Node add(Node head_ref, int data) {
        Node newNode = new Node(data);
        newNode.down = head_ref;
        head_ref = newNode;

        return head_ref;
    }

    public Node flatten(Node root) {
        if (root == null || root.right == null)
            return root;
        root.right = flatten(root.right);

        root = merge(root, root.right);

        return root;


    }

    public Node merge(Node a, Node b) {
        if (a != null && b == null)
            return a;
        if (a == null && b != null)
            return b;

        Node result;

        if (a.data < b.data) {
            result = a;
            result.down = merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }
        result.right = null;
        return result;
    }

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(" " + temp.data);
            temp = temp.down;
        }
    }

    public static void main(String[] args) {
        FlattenLinkedList ft = new FlattenLinkedList();
        ft.head = ft.add(ft.head, 30);
        ft.head = ft.add(ft.head, 8);
        ft.head = ft.add(ft.head, 7);
        ft.head = ft.add(ft.head, 5);

        ft.head.right = ft.add(ft.head.right, 20);
        ft.head.right = ft.add(ft.head.right, 15);

        ft.head.right.right = ft.add(ft.head.right.right, 50);
        ft.head.right.right = ft.add(ft.head.right.right, 22);
        ft.head.right.right = ft.add(ft.head.right.right, 19);

        Node flatterned = ft.flatten(ft.head);

        ft.head = flatterned;
        ft.print();


    }


}
