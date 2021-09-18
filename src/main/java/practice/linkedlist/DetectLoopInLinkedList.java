package practice.linkedlist;

public class DetectLoopInLinkedList {

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

    private static void detectLoop()
    {
        Node slow = head;
        Node fast = head;
        boolean found = false;
        while(slow != null && fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                found = true;
                break;
            }
        }
        System.out.println(" loop detected ");

        countLenth(slow);

        if(slow == fast)
        {
            slow = head;

            if(slow != fast)
            {
                while(slow.next != fast.next)
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                System.out.println(fast.next.data);
            }
            else
            {
                while(fast != slow)
                    fast = fast.next;
                System.out.println(fast.next.data);

            }

            fast.next = null;

        }

    }

    private static void countLenth(Node slow)
    {
        int count =0;
        Node temp = slow;
        while(temp.next!= slow)
        {
            temp = temp.next;
            count++;
        }
        System.out.println();
        System.out.println("length "+ count);
    }

    public static void main(String[] args) {
        insert(1);
        insert(2    );
        insert(3);
        insert(4);
        insert(5);
        insert(6);

        head.next.next.next.next.next.next = head.next.next.next;
        detectLoop();
        printList();
    }
}
