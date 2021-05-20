package datastructure.linkelist.singleLinkedlist;

import java.io.PrintWriter;

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
public class PrintNthNode {

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
        head = newNode;
    }

    public void print()
    {
        if(head == null)
        {
            System.out.println(" No element ");
            return;
        }
        Node temp = head;
        while(temp != null)
        {
            System.out.println(temp.data +" ");
            temp = temp.next;
        }
    }

    public void getNthNode(int pos)
    {
        Node temp = head;
        if(head == null)
        {
            System.out.println(" no node present ");
            return;
        }
        int count=0;
        while(temp != null && count != pos)
        {
            temp = temp.next;
            count++;
        }
        if(temp !=null)
            System.out.println(temp.data);
    }

    public static void main(String[] args) {
        PrintNthNode list = new PrintNthNode();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        System.out.println();
        list.getNthNode(2);



    }
}
