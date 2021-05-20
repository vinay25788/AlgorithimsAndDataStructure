package datastructure.linkelist.singleLinkedlist;
public class ReverseLinkedListUsingRecursion {

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


    public Node reverseUsingRecursion(Node cur)
    {
        if(cur == null)
            return cur;

        if(cur.next == null)
            return cur;
        Node newNode = reverseUsingRecursion(cur.next);
        cur.next.next = cur;
        cur.next= null;
        return newNode;
    }

    public static void main(String[] args) {
        ReverseLinkedListUsingRecursion list = new ReverseLinkedListUsingRecursion();
        list.add(1);
        list.add(2);
        list.add(3);

        list.print();
        System.out.println();

        System.out.println(" reversed List ");
       list.head = list.reverseUsingRecursion(list.head);
       list.print();



    }
}
