package practice.linkedlist;

import java.util.Stack;

public class ReverseListInGroup {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    private static void insert(int key) {
        Node newNode = new Node(key);
        newNode.next = head;
        head = newNode;
    }

    private static void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }


    static Node reverse(Node head, int k) {
        if (head == null)
            return null;
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }


        if (next != null)
            head.next = reverse(current, k);


        return prev;
    }


    public static void main(String[] args) {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);
        insert(6);
        insert(7);
        printList();
        head = reverse(head, 4);
        System.out.println();
        printList();
    }
}
