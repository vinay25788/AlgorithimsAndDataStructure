package datastructure.linkelist.singleLinkedlist;
public class PairwiseSwap {

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

    public void pairWiseSwap()
    {
        Node temp = head;
        while(temp != null && temp.next !=null)
        {
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data =k;
            temp =temp.next.next;
        }
    }

    public static void main(String[] args) {
        PairwiseSwap list = new PairwiseSwap();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        System.out.println();
        list.pairWiseSwap();
        System.out.println();
        list.print();


    }
}
