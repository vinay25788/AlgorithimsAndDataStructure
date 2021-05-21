package datastructure.linkelist.singleLinkedlist;
public class SingleLinkedListPallindrome {

    Node head;
    Node slow,fast,secondHalf;
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
        int count=0;
        while(temp != null && count != pos)
        {
            temp = temp.next;
            count++;
        }
        if(temp !=null)
            System.out.println(temp.data);
    }
    public void isPallindrome()
    {

        Node previousOfSlow = head;
        Node midNode = null;
        fast = head;
        slow = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            previousOfSlow = slow;
            slow  = slow.next;
        }
        if(fast != null )
        {
            midNode = slow;
            slow = slow.next;
        }
        secondHalf = slow;
        previousOfSlow.next = null;
        reverse();
        boolean isPallindrome = compare(head,secondHalf);
        reverse();
        if(midNode!=null)
        {
            previousOfSlow.next = midNode;
            midNode.next = secondHalf;
        }
        else
            previousOfSlow.next = secondHalf;

        if(isPallindrome)
            System.out.println(" pallindrome found ");
        else
            System.out.println(" not a pallindrome ");
    }
    public boolean compare(Node head,Node secondHalf)
    {
        Node temp = head;
        Node temp2 = secondHalf;

        while(temp != null & temp2 != null)
        {
            if( temp.data == temp2.data)
            {
                temp = temp.next;
                temp2 = temp2.next;
            }
            else
                return false;

        }
        if(temp == null && temp2 == null)
            return true;
        return false;
    }
    public void reverse()
    {
        Node next = null;
        Node cur = secondHalf;
        Node previous = null;
        while(cur != null)
        {
            next = cur.next;
            cur.next = previous;
            previous = cur;
            cur = next;
        }
        secondHalf = previous;
    }

    public static void main(String[] args) {
        SingleLinkedListPallindrome list = new SingleLinkedListPallindrome();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3);

        list.add(2);
        list.add(1);
        list.print();
        System.out.println();
        list.getNthNode(2);

        list.isPallindrome();

    }
}
