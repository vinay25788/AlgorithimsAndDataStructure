package datastructure.linkelist.singleLinkedlist;
public class MultiplyTwoNumberUsingList {

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


    public static void multiply(Node list1, Node list2)
    {
        int n1=0, n2=0;
        while(list1!= null | list2 != null)
        {
            if(list1 != null)
            {
                n1 = (n1*10)+list1.data;
                list1 = list1.next;
            }
            if(list2 != null)
            {
                n2 = ( n2*10) + list2.data;
                list2 = list2.next;
            }
        }
        System.out.println(" result is "+n1*n2);

    }
    public static void main(String[] args) {
        MultiplyTwoNumberUsingList list = new MultiplyTwoNumberUsingList();
        list.head1 = new Node(1);
        list.head1.next = new Node(1);
        list.head2 = new Node(1);
        list.head2.next = new Node(1);
        list.print();
        System.out.println();

        list.multiply(list.head1,list.head2);




    }
}
