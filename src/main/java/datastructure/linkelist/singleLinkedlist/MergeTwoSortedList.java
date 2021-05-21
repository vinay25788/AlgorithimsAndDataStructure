package datastructure.linkelist.singleLinkedlist;
public class MergeTwoSortedList {

    Node head;
    Node head1, head2;
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
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
    }


    public Node merge(Node h1,Node h2)
    {
        if(h1 == null)
            return h2;
        if(h2 == null)
            return h1;

        if(h1.data<h2.data)
        {
            h1.next = merge(h1.next,h2);
            return h1;
        }
        else
        {
            h2.next = merge(h1,h2.next);
            return h2;
        }
    }

    public static void main(String[] args) {

        MergeTwoSortedList list = new MergeTwoSortedList();

        list.head1 = new Node(1);
        list.head1.next = new Node(5);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(13);

        list.head2 = new Node(2);
        list.head2.next = new Node(8);
        list.head2.next.next = new Node(10);

        list.head = list.merge(list.head1,list.head2);

    list.print();


        System.out.println();




    }
}
