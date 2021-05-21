package datastructure.linkelist.singleLinkedlist;

import javax.print.event.PrintEvent;

public class ReverseLinkedListWithoutActualReverse {

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


    public  void reverse(Node cur)
    {
        if(cur == null)
            return;
        reverse(cur.next);
        System.out.print(cur.data+" ");

    }

    public static void main(String[] args) {
        ReverseLinkedListWithoutActualReverse list = new ReverseLinkedListWithoutActualReverse();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        System.out.println();

        list.reverse(list.head);



    }
}
