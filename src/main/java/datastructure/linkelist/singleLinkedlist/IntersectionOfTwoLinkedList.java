package datastructure.linkelist.singleLinkedlist;
public class IntersectionOfTwoLinkedList {

    Node list1 = null, list2 =null;
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

    public void sortedIntersection(Node head1, Node head2)
    {
            Node temp1 = head1;
            Node temp2 = head2;
            while(temp1 !=null && temp2 !=null)
            {
                if(temp1.data == temp2.data)
                {
                    add(temp1.data);
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
                else if ( temp1.data<temp2.data)
                    temp1 =temp1.next;
                else
                    temp2 = temp2.next;
            }
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedList list = new IntersectionOfTwoLinkedList();

        list.list1 = new Node(1);
        list.list1.next = new Node(2);
        list.list1.next.next = new Node(3);
        list.list1.next.next.next = new Node(5);


        list.list2 = new Node(4);
        list.list2.next = new Node(5);
        list.list2.next.next = new Node(7);
        list.list2.next.next.next = new Node(8);

        list.sortedIntersection(list.list1, list.list2);


        System.out.println();

        list.print();




    }
}
