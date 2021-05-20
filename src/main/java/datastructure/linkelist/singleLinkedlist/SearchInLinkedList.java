package datastructure.linkelist.singleLinkedlist;

public class SearchInLinkedList {

    Node head;
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

    public void add(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next= newNode;
    }
    public void print()
    {
        Node temp = head;
        if(temp == null)
        {
            System.out.println(" no element in list ");
            return;
        }
        while(temp !=null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public void search(int data)
    {
        if(head == null)
        {
            System.out.println(" no element in list ");
            return;
        }
        Node temp = head;
        while(temp != null)
        {
            if(temp.data == data)
            {
                System.out.println("element found ");
                return;
            }
            temp = temp.next;

        }
        System.out.println(" Element not found ");
    }

    public static void main(String[] args) {
        SearchInLinkedList list = new SearchInLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        list.search(3);





    }

}
