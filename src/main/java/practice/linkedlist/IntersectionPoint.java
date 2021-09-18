package practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionPoint {

    static Node head,head2;

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

    private static void insert2(int key)
    {
        if(head2 == null)
        {
            head2 = new Node(key);
            return;
        }
        Node temp = new Node(key);
        temp.next = head2;
        head2 = temp;
    }

    private static void printList(Node node)
    {
        Node temp = node;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    private static int getIntersectNode(Node head,Node head2)
    {
        Set<Integer> set = new HashSet<>();
        Node cur = head;

        while(cur != null)
        {
            set.add(cur.data);
            cur = cur.next;
        }
        Node cur2 = head2;
        while(cur2 != null)
        {
            if(set.contains(cur2.data))
                return cur2.data;
            cur2 = cur2.next;
        }
        return -1;

    }



   static void  revereLinkedList()
    {
        Node cur = head;
        Node prev = null;
        Node next = null;
        while(cur != null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }



    public static void main(String[] args) {
        insert(1);
        insert(2 );
        insert(3);
        insert(4);
        insert(5 );
        insert(6);
        insert(7);


        insert2(4);



        printList(head);
        System.out.println();
        printList(head2);
        System.out.println();
        int interSectPoint = getIntersectNode(head,head2);
        if( interSectPoint == -1)
        {
            System.out.println(" not found ");
        }
        else
            System.out.println(interSectPoint);

      printList(head);

      revereLinkedList();
        System.out.println();
      printList(head);
        System.out.println();
        printWithoutReverse(head);
        System.out.println();
        revereLinkedList();
        printList(head);
        System.out.println();
        rotateLinkedList(head,2);

        printList(head);
    }
   static void  rotateLinkedList(Node node,int k)
    {
        Node cur = node;
        while(cur.next != null)
            cur = cur.next;
        cur.next = node;
        cur = node;
        for(int i=0;i<k-1;i++)
            cur = cur.next;
        head = cur.next;
        cur.next = null;

    }
    private static void printWithoutReverse(Node head)
    {
        if(head == null)
            return;
        printWithoutReverse(head.next);
        System.out.print(head.data+ " ");
    }
}

