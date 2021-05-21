package datastructure.linkelist.singleLinkedlist;

public class ReArrangeOfElementsInLinkedList {

    Node head;

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
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public Node reArrange() {
        if (head == null)
            return null;
        Node prev = head;
        Node cur = head.next;
        Node next;
        while (cur != null) {
            if (prev.data > cur.data) {
                int t = prev.data;
                prev.data = cur.data;
                cur.data = t;
            }
            next = cur.next;
            if (next != null && cur.data < next.data) {
                int temp = next.data;
                next.data = cur.data;
                cur.data = temp;
            }
            prev = next;
            if(cur.next == null)
                break;
            cur = next.next;

        }
        return head;
    }

    public static void main(String[] args) {
        ReArrangeOfElementsInLinkedList list = new ReArrangeOfElementsInLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        System.out.println();

        System.out.println();
        list.print();
        Node head_ref = list.reArrange();
        list.head = head_ref;
        list.reArrange();
        System.out.println();
        list.print();


    }
}
