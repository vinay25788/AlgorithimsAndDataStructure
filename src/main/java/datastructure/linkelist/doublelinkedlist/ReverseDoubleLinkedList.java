package datastructure.linkelist.doublelinkedlist;

public class ReverseDoubleLinkedList {
    Node head;
    public void add(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
           head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;

    }
    public void reverse()
    {
        Node temp = null;
        Node cur = head;
        while(cur != null)
        {
            temp = cur.prev;
            cur.prev = cur.next;
            cur.next = temp;
            cur = cur.prev;

        }
        if(temp != null)
            head = temp.prev;
    }

    public void print()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(" "+temp.data);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        ReverseDoubleLinkedList obj = new ReverseDoubleLinkedList();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.add(4);
        obj.print();
        obj.reverse();
        System.out.println();
        obj.print();

    }
}
