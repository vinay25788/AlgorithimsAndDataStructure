package datastructure.linkelist.singleLinkedlist;
public class Sort0s1s2s {

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

    public void sort0s1s2s()
    {
        Node temp = head;
        int[] count = {0,0,0};
        while(temp != null)
        {
            count[temp.data]++;
            temp = temp.next;
        }

        temp = head;
        int i=0;
        while(temp != null)
        {
            if(count[i] ==0)
                ++i;
            else
            {
                temp.data =i;
                --count[temp.data];
                temp =temp.next;
            }
        }
    }


    public static void main(String[] args) {
        Sort0s1s2s list = new Sort0s1s2s();
        list.add(1);
        list.add(0);
        list.add(2);
        list.add(1);
        list.add(0);
        list.print();
        System.out.println();

    list.sort0s1s2s();
     list.print();


    }
}
