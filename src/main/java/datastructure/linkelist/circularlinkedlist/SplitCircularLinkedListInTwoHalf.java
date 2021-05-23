package datastructure.linkelist.circularlinkedlist;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SplitCircularLinkedListInTwoHalf {

    Node head, last, head1, head2;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void print(Node head) {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
        }
    }

    public void split() {
        Node temp = head;
        Node slow = head, fast = head;
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next.next == head)
            fast = fast.next;

        head1 = head;
        if (head.next != head)
            fast.next = slow.next;
        head2 = fast.next;
        slow.next = head;
    }

    public static void main(String[] args) {
        SplitCircularLinkedListInTwoHalf list = new SplitCircularLinkedListInTwoHalf();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = list.head;
        list.print(list.head);
        System.out.println();
        list.split();
        list.print(list.head1);
        System.out.println();
        list.print(list.head2);

    }
}
