package datastructure.linkelist.singleLinkedlist;
public class Sort0s1s2sUsingSingleLinkedList {

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

    public  void sort()
    {
        Node cur = head;
        Node zeroH = new Node(0), oneH= new Node(0), twoH= new Node(0);
        Node zero = zeroH, one = oneH, two = twoH;

        while(cur != null)
        {
            if(cur.data ==0)
            {
                zero.next = cur;
                zero = zero.next;
            }
            else if( cur.data ==1)
            {
                one.next = cur;
                one = one.next;
            }
            else
            {
                two.next = cur;
                two = two.next;

            }
            cur = cur.next;

        }

        zero.next = (oneH.next != null ? oneH.next:twoH.next);
        one.next = twoH.next;
        two.next = null;
        head = zeroH.next;

    }


    public static void main(String[] args) {
        Sort0s1s2sUsingSingleLinkedList list = new Sort0s1s2sUsingSingleLinkedList();
        list.add(1);
        list.add(2);
        list.add(0);
        list.add(0);
        list.add(1);
        list.print();
        System.out.println();
        list.sort();
        list.print();



    }
}
