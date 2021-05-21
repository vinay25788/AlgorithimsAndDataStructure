package datastructure.linkelist.singleLinkedlist;

public class MiddleOfTheLinkedList {

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

    public void getNthNode(int pos)
    {
        Node temp = head;
        if(head == null)
        {
            System.out.println(" no node present ");
            return;
        }
        int count=1;
        while(temp != null && count != pos)
        {
            temp = temp.next;
            count++;
        }
        if(temp !=null)
            System.out.println(temp.data);
    }
    public  void middleOftheList()
    {
        Node temp = head;
        Node slow = head , fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

        }
        System.out.println(" middle of the list " +slow.data);
        //1->2>3->4->5
    }

    public static void main(String[] args) {
        MiddleOfTheLinkedList list = new MiddleOfTheLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        System.out.println();
        list.getNthNode(1);
        list.middleOftheList();



    }
}
