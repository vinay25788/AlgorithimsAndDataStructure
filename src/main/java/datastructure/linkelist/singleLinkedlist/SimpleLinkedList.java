package datastructure.linkelist.singleLinkedlist;

public class SimpleLinkedList {

    Node head;
    class Node
    {
        int data;
        Node next;

        Node(int data,Node next)
        {
            this.data = data;
            this.next = next;
        }
    }




    public void add(int data)
    {
        Node newNode = new Node(data,null);
        if(head == null)
        {
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void print()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" -->");
            temp = temp.next;
        }
    }

    public  void deleteNode(int data)
    {
         Node temp = head;
         Node prev = null;
         while(temp !=null && temp.data != data )
         {
             prev = temp;
             temp = temp.next;
         }
         prev.next = temp.next;

    }

    public  void deleteFromIndex(int pos)
    {
        if(pos ==1)
        {
            head = head.next;
        }
        else
        {
            Node temp = head;
            Node prev= null;
            int ind=0;
            while( temp != null & ind<pos )
            {
                prev = temp;
                temp = temp.next;
                ind++;
            }
            prev.next = temp.next;

        }
    }

    public static void main(String[] args) {
        SimpleLinkedList linkedList = new SimpleLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.print();
        linkedList.deleteNode(3);
        System.out.println();
        linkedList.print();
        linkedList.add(3);
        linkedList.add(4);
        System.out.println();
        linkedList.print();
        System.out.println();
        linkedList.deleteFromIndex(2);
        linkedList.print();

    }
}
