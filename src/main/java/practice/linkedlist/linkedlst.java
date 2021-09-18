package practice.linkedlist;

public class linkedlst {

    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    static void insert(int key)
    {
        if(head == null)
        {
            head = new Node(key);
            return;
        }
        Node temp = new Node(key);
        temp.next = head;
        head = temp;
    }

    static void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            while(temp != null)
            {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
        }
    }

    private static void delete(int key)
    {
        Node temp = head;
        while(temp != null)
        {
            if(temp.next != null && temp.next.data == key)
            {
                temp.next = temp.next.next;

            }
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);
        printList();
        delete(3);
        System.out.println();
        printList();
    }
}
