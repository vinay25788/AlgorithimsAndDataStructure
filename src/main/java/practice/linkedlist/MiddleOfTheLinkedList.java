package practice.linkedlist;

public class MiddleOfTheLinkedList {

    static Node head;

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

    private static void insert(int key)
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

    private static void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
        private static void middleOfTheList()
        {
            Node fast = head;
            Node slow = head;

            while(fast != null)
            {
                fast = fast.next;
                if(fast != null)
                {
                    fast = fast.next;
                    slow  = slow.next;
                }

            }

            System.out.println(slow.data);
        }

    public static void main(String[] args) {
        insert(1);
        insert(2    );
        insert(3);
        insert(4);
        insert(5);
        insert(6);
        printList();
        System.out.println();
        middleOfTheList();
    }
}
