package datastructure.linkelist.singleLinkedlist;

import java.util.Stack;

public class AddTwoNumberRepresentedByList {

    Node head1, head2, head;

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

    public void add(Node first, Node second) {
        Node prev = null;
        int carry = 0, sum = 0;
        Node temp = null, res= null;
        while (first != null || second != null) {
            sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);

            carry = sum > 10 ? 1 : 0;
            sum = sum % 10;
            temp = new Node(sum);

            if(res == null)
                res = temp;
            else
                prev.next = temp;

            prev = temp;

            if(first !=null)
                first = first.next;
            if(second != null)
                second = second.next;


        }
        if(carry>0)
            temp.next = new Node(carry);

        head = res;
    }

    public void add()
    {
        Node first = head1;
        Node second = head2;
        int carry =0;

        Node result = null;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while(first != null)
        {
            st1.push(first.data);
            first = first.next;
        }
        while(second != null)
        {
            st2.push(second.data);
            second = second.next;
        }
        while(!st1.isEmpty() || !st2.isEmpty())
        {
            int a=0,b=0;
            if(st1.isEmpty()==false)
                a = st1.pop();
            if(!st2.isEmpty())
                b = st2.pop();
            int sum = carry+a+b;
            carry = sum/10;
            sum = sum %10;
            Node temp = new Node(sum);
            if( result == null)
                result = temp;
            else
            {
                temp.next = result;
                result = temp;
            }
        }
        if( carry>0)
        {
            Node temp = new Node(carry);
            temp.next = result;
            result = temp;
        }
        head = result;
    }

    public static void main(String[] args) {
        AddTwoNumberRepresentedByList list = new AddTwoNumberRepresentedByList();

        list.head1 = new Node(1);
        list.head1.next = new Node(8);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(9);

        list.head2 = new Node(1);
        list.head2.next = new Node(8);
        list.head2.next.next = new Node(9);
        list.head2.next.next.next = new Node(9);

        System.out.println();
        list.head = list.head1;
        list.print();
        list.head = list.head2;
        System.out.println();
        list.print();

        list.add(list.head1, list.head2);

        System.out.println();
        list.print();
        System.out.println();
        list.add();
        list.print();



    }
}
