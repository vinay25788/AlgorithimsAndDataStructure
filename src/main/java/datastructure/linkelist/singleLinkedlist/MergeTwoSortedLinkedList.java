package datastructure.linkelist.singleLinkedlist;

public class MergeTwoSortedLinkedList {

    Node head;
    Node a, b;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        if (head == null) {
            System.out.println(" No element ");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public void mergeList(Node a, Node b) {
        Node node1 = a;
        Node node2 = b;

        Node res = null;
        while (node1 != null && node2 != null) {
            if (node1.data <= node2.data) {
                Node temp = node1.next;
                node1.next = res;
                res = node1;
                node1 = temp;
            } else {
                Node temp = node2.next;
                node2.next = res;
                res = node2;
                node2 = temp;
            }

        }

        while (node1 != null) {

            Node temp = node1.next;
            node1.next = res;
            res = node1;
            node1 = temp;
        }

        while (node2 != null) {
            Node temp = node2.next;
            node2.next = res;
            res = node2;
            node2 = temp;
        }

        head = res;
    }


    public static void main(String[] args) {
        MergeTwoSortedLinkedList list = new MergeTwoSortedLinkedList();

        list.a = new Node(1);
        list.a.next = new Node(4);
        list.a.next.next = new Node(7);

        list.b = new Node(2);
        list.b.next = new Node(3);
        list.b.next.next = new Node(6);

        list.mergeList(list.a, list.b);


        list.print();


    }
}
