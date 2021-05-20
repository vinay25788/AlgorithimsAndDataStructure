package datastructure.linkelist.singleLinkedlist;

public class LengthOfLinkedList {
    class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    public void add(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;
        }
    }

    public void getLengthUsingIterative()
    {
        Node temp = head;
        int length =0;
        while(temp != null)
        {
            temp = temp.next;
            length++;
        }
        System.out.println("length of linkedlist "+length);
    }

    public int getLengthUsingRecursive(Node temp)
    {
        if(temp == null)
        {
            return 0;
        }
       return 1+ getLengthUsingRecursive(temp.next);
    }

    public void print()
    {
        Node temp = head;
        while(temp !=null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LengthOfLinkedList list = new LengthOfLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        list.getLengthUsingIterative();
        System.out.println("length "+list.getLengthUsingRecursive(list.head));
    }
}
