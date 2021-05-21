package datastructure.linkelist.singleLinkedlist;

public class DeleteAlternate {

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
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public Node deleteAlt(Node cur) {
        if (cur == null)
            return null;
        Node node = cur.next;

        if (cur == null)
            return null;
        cur.next = node.next;
        cur = node.next;
        cur.next = deleteAlt(cur.next);

        return cur;

    }


    public static void main(String[] args) {
        DeleteAlternate list = new DeleteAlternate();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        System.out.println();

        list.deleteAlt(list.head);
        list.print();


    }
}
