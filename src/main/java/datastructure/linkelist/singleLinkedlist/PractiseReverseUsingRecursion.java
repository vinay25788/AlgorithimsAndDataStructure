package datastructure.linkelist.singleLinkedlist;
public class PractiseReverseUsingRecursion {

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


    public Node reverse(Node cur)
    {
        if(cur == null)
            return cur;
        if(cur.next == null)
            return cur;
        Node newNode = reverse(cur.next);
        cur.next.next = cur;
        cur.next=null;
        return newNode;

    }
    public Node reverseUsingIterative(Node head)
    {
        Node next = null;
        Node cur = head;
        Node prev = null;
        while(cur != null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        PractiseReverseUsingRecursion list = new PractiseReverseUsingRecursion();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        System.out.println();
        Node reverse=list.reverse(list.head);
        list.head = reverse;
        list.print();

        list.head = list.reverseUsingIterative(list.head);
        System.out.println("rever using iterative ");
        list.print();

    }
}
