package practice.linkedlist;

// Java program to sort a
// linked list that is alternatively
// sorted in increasing and decreasing order
 class LinkedList {
    Node head; // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    Node newNode(int key)
    {
        return new Node(key);
    }

    /* This is the main function that sorts
    the linked list.*/
    void sort()
    {
		/* Create 2 dummy nodes and initialise as
		heads of linked lists */
        Node Ahead = new Node(0), Dhead = new Node(0);

        // Split the list into lists
        splitList(Ahead, Dhead);

        Ahead = Ahead.next;
        Dhead = Dhead.next;

        // reverse the descending list
        Dhead = reverseList(Dhead);

        // merge the 2 linked lists
        head = mergeList(Ahead, Dhead);
    }

    /* Function to reverse the linked list */
    Node reverseList(Node Dhead)
    {
        Node current = Dhead;
        Node prev = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        Dhead = prev;
        return Dhead;
    }

    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // A utility function to merge
    // two sorted linked lists
    Node mergeList(Node head1, Node head2)
    {
        // Base cases
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        Node temp = null;
        if (head1.data < head2.data) {
            temp = head1;
            temp.next = mergeList(head1.next, head2);
        }
        else {
            temp = head2;
            temp.next = mergeList(head1, head2.next);
        }
        return temp;
    }

    // This function alternatively splits
    // a linked list with head as head into two:
    // For example, 10->20->30->15->40->7 is
    // splitted into 10->30->40
    // and 20->15->7
    // "Ahead" is reference to head of ascending linked list
    // "Dhead" is reference to head of descending linked list
    void splitList(Node Ahead, Node Dhead)
    {
        Node ascn = Ahead;
        Node dscn = Dhead;
        Node curr = head;

        // Link alternate nodes

        while (curr != null) {
            // Link alternate nodes in ascending order
            ascn.next = curr;
            ascn = ascn.next;
            curr = curr.next;

            if (curr != null) {
                dscn.next = curr;
                dscn = dscn.next;
                curr = curr.next;
            }
        }

        ascn.next = null;
        dscn.next = null;
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        LinkedList llist = new LinkedList();
        llist.head = llist.newNode(10);
        llist.head.next = llist.newNode(40);
        llist.head.next.next = llist.newNode(53);
        llist.head.next.next.next = llist.newNode(30);
        llist.head.next.next.next.next = llist.newNode(67);
        llist.head.next.next.next.next.next = llist.newNode(12);
        llist.head.next.next.next.next.next.next = llist.newNode(89);

        System.out.println("Given linked list");
        llist.printList();

        llist.sort();

        System.out.println("Sorted linked list");
        llist.printList();
    }

} /* This code is contributed by Rajat Mishra */
