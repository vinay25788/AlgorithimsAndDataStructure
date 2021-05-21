package datastructure.linkelist.singleLinkedlist;
public class DecimalEquilivalentOfBinary {

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
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
    }

    public void convertIntoDecimal()
    {
        Node temp = head;
        int res =0;

        while(temp != null)
        {
            res = (res << 1) + temp.data;
            temp = temp.next;
        }
        System.out.println(" decimal equivalent is "+res);
    }

    public static void main(String[] args) {
        DecimalEquilivalentOfBinary list = new DecimalEquilivalentOfBinary();
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(1);
        list.print();
        System.out.println();
        list.convertIntoDecimal();

    }
}
