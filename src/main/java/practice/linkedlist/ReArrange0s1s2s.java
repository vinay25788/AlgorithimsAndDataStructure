package practice.linkedlist;

public class ReArrange0s1s2s {

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

    private static void insert(int key)
    {
        if(head == null)
        {
            head = new Node(key);
            return;
        }
        else
        {
            Node temp = new Node(key);
            temp.next = head;
            head = temp;
        }

    }

    private static void printList()
    {
        Node cur = head;
        while(cur != null)
        {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
    }
    private static void reArrange()
    {
        Node cur = head;
        int[] count = new int[3];
        while(cur != null)
        {
            count[cur.data]++;
            cur = cur.next;
        }

        int i=0;
        cur = head;
        while(cur != null)
        {
            if(count[i] ==0)
            {
                i++;
            }
            else
            {
                cur.data = i;
                cur = cur.next;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        insert(0);
        insert(2);
        insert(0);
        insert(1);
        insert(1);
        insert(2);
        insert(0);
        insert(1);
        printList();
        reArrange();
        System.out.println();
        printList();
    }
}
