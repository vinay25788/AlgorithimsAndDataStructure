package datastructure.linkelist.singleLinkedlist;

import java.util.Stack;

public class ReverseLinkedListInGroupOfK {

    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        if (head == null) {
            System.out.println(" No element ");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void reverseInGroup(int k) {
        Node cur = head;

        Node prev = null;
        Stack<Node> st = new Stack<>();
        while (cur != null) {
            int count = 0;
            while (cur != null && count < k) {
                st.push(cur);
                cur = cur.next;
                count++;

            }

            while (st.size() > 0) {
                if (prev == null) {
                    prev = st.peek();
                    head = prev;
                    st.pop();
                } else {
                    prev.next = st.peek();
                    prev = prev.next;
                    st.pop();
                }
            }

        }
        prev.next = null;

    }

    public Node reverseUsingRecursion(Node head,int k)
    {
       if(head == null)
           return null;
        Node cur = head;
        Node next = null;
        Node prev = null;
        int count =0;
        while( cur != null && count <k )
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }
        if( next != null)
            head.next = reverseUsingRecursion(next,k);
        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedListInGroupOfK list = new ReverseLinkedListInGroupOfK();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        list.print();
        System.out.println();

        list.reverseInGroup(3);
        System.out.println();
        list.print();

        System.out.println();
        list.reverseUsingRecursion(list.head,3);
                list.print();


    }
}
