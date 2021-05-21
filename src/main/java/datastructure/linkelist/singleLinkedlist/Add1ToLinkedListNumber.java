package datastructure.linkelist.singleLinkedlist;
public class Add1ToLinkedListNumber {

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


    public int addWithCarry(Node head)
    {
        if(head == null)
            return 1;
        int result = head.data + addWithCarry(head.next);
        head.data = result%10;
        return result/10;

    }

    public Node add1ToNumber(Node head)
    {
        int carry = addWithCarry(head);
        if(carry>0)
        {
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode;
        }

        return head;
    }

    public static void main(String[] args) {
        Add1ToLinkedListNumber list = new Add1ToLinkedListNumber();
        list.add(9);
        list.add(9);
        list.add(1);
        list.print();
        System.out.println();

        Node head = list.add1ToNumber(list.head);
        list.head = head;
        list.print();


    }
}
