package datastructure.linkelist.singleLinkedlist;

public class SortLinkedList {

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

    public Node sort(Node head) {
        Node prev = head;
        Node cur = head.next;
        while (cur != null) {
            if (prev.data >cur.data) {
                prev.next = cur.next;
                cur.next = head;
                head = cur;
                prev = head;
                cur = head.next;

            } else
            {
                prev = cur;
                cur = cur.next;

            }

        }
    return head;
    }


    public static void main(String[] args) {
        SortLinkedList list = new SortLinkedList();
        list.add(1);
        list.add(20);
        list.add(3);
        list.add(40);
        list.add(5);
        list.print();
        System.out.println();

      list.head =  list.sort(list.head);
        System.out.println();
        list.print();
    }
}
