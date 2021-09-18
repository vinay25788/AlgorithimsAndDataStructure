package practice.linkedlist;



public class DeteleFromGivenPosition {

    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    static void insert(int key)
    {
        if(head == null)
        {
            head = new Node(key);
            return;
        }
        Node temp = new Node(key);
        temp.next = head;
        head = temp;
    }

    static void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            while(temp != null)
            {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
        }
    }

    private static int getLength(Node node)
    {
        if(node == null)
            return 0;
        return 1+ getLength(node.next);
    }

    private static int getLength()
    {
        return getLength(head);
    }

    private static void delete(int pos)
    {
        Node temp = head;
        int count =0;
        Node prev = null;
        while(temp != null)
        {
            count++;
            if(count == pos)
            {
               prev.next = temp.next;

            }

            prev = temp;
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);

        printList();
        delete(3);
        System.out.println();
        printList();
        System.out.println();
        System.out.println(getLength());

    }
}
