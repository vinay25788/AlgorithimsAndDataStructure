package practice.linkedlist;

public class LinkedListPallindrome {

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

    private static boolean isPallindrome(Node head)
    {
        Node slow=head,fast=head,secondhalf=null,previousOfSlow=null,middleNode=null;
        boolean isPallindrome = false;
        if(head != null && head.next != null)
        {
            while(fast != null && fast.next != null)
            {
                fast = fast.next.next;
                previousOfSlow = slow;
                slow = slow.next;
            }
            if(fast != null)
            {
                middleNode = slow;
                slow = slow.next;
            }
            previousOfSlow.next = null;
            secondhalf = slow;
           Node reversed =  reverse(secondhalf);

             isPallindrome = compareList(head,reversed);
            reversed = reverse(reversed);

            if(middleNode != null)
            {
                previousOfSlow.next = middleNode;
                middleNode.next = reversed;
            }
            else
                previousOfSlow.next = reversed;

        }
        return isPallindrome;
    }

    static boolean compareList(Node head1,Node head2)
    {
        Node temp1 = head1;
        Node temp2 = head2;
        while(temp1 != null && temp2 != null)
        {
            if(temp1.data != temp2.data)
                return false;
            temp1  = temp1.next;
            temp2 = temp2.next;
        }
        if(temp1 == null && temp2 == null)
            return true;
        return false;
    }
    private static Node reverse(Node head)
    {
        Node next = null, prev = null,cur = head;
        while(cur != null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }




    public static void main(String[] args) {
        insert(1);
        insert(2    );
        insert(3);
        insert(4);
        insert(3);
        insert(2);
        insert(9);

        printList();
        System.out.println(" Pallindrome "+isPallindrome(head));
    }
}
