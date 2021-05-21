package datastructure.linkelist.singleLinkedlist;

public class CountTheNumberOfTimeNodeOccur {

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

    public int count(Node head, int data)
    {

        if(head == null)
            return 0;
        int  count= count(head.next,data);
        if(head.data == data)
            count++;
        return count;
    }


    public void getNthNode(int pos)
    {
        Node temp = head;
        if(head == null)
        {
            System.out.println(" no node present ");
            return;
        }
        int count=0;
        while(temp != null && count != pos)
        {
            temp = temp.next;
            count++;
        }
        if(temp !=null)
            System.out.println(temp.data);
    }

    public static void main(String[] args) {
        CountTheNumberOfTimeNodeOccur list = new CountTheNumberOfTimeNodeOccur();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5);list.add(5);
        list.add(5);list.add(5);


        list.print();
        System.out.println();
        list.getNthNode(2);
        System.out.println(list);
        System.out.println(list.count(list.head, 5));


    }
}

