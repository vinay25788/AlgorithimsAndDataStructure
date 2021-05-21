package datastructure.linkelist.singleLinkedlist;
public class SegrigateEvenAndOdd {

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

    public void segregateEvenOdd()
    {
        Node temp = head;
        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;
        while( temp != null)
        {
            int data = temp.data;
            if(data %2 ==0)
            {
                if( evenStart == null)
                {
                    evenStart = temp;
                    evenEnd = temp;
                }
                else
                {
                    evenEnd.next = temp;
                    evenEnd = temp;
                }
            }
            else
            {
                if(oddStart == null)
                {
                    oddStart = temp;
                    oddEnd = temp;
                }
                else
                {
                    oddEnd.next = temp;
                    oddEnd = temp;
                }
            }
            temp = temp.next;
        }

        if( oddStart == null && evenStart == null)
        {
            System.out.println(" empty ");
            return;
        }
        evenEnd.next = oddStart;
        oddEnd.next = null;
        head = evenStart;
    }

    public static void main(String[] args) {
        SegrigateEvenAndOdd list = new SegrigateEvenAndOdd();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(10);
        list.add(12);
        list.add(19);
        list.print();
        System.out.println();
        list.segregateEvenOdd();
        System.out.println();
        list.print();


    }
}
