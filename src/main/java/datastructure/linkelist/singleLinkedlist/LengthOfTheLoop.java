package datastructure.linkelist.singleLinkedlist;

public class LengthOfTheLoop {

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
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public void getNthNode(int pos) {
        Node temp = head;
        if (head == null) {
            System.out.println(" no node present ");
            return;
        }
        int count = 0;
        while (temp != null && count != pos) {
            temp = temp.next;
            count++;
        }
        if (temp != null)
            System.out.println(temp.data);
    }

    public void loopLength() {
        Node slow = head;
        Node fast = head;
        int length =1;
        boolean loopDetected = false;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if( slow.data == fast.data)
            {
                System.out.println(" loop detected ");
                loopDetected = true;
                break;
            }
        }
        fast = head;

        while(fast.data != slow.data)
        {
            fast = fast.next;
            slow = slow.next;
            length++;
        }
        if(loopDetected)
        System.out.println("length of the loop "+length);
    }

    public static void main(String[] args) {
        LengthOfTheLoop list = new LengthOfTheLoop();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        list.head.next.next.next.next.next = list.head.next.next;
        System.out.println();
        list.getNthNode(2);
        list.loopLength();


    }
}
