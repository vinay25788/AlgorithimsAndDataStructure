package practice.linkedlist;

public class MergeTwoSortedList {

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

    static Node head,head2;

    private static void insert(int val,int data)
    {
      if(val == 1)
      {
          if(head == null)
          {
              head = new Node(data);
              return;
          }
          else
          {
              Node temp = new Node(data);
              temp.next = head;
              head = temp;
          }
      }
      else
      {
              if(head2 == null)
              {
                  head2= new Node(data);
                  return;
              }
              else
              {
                  Node temp = new Node(data);
                  temp.next = head2;
                  head2 = temp;
              }
          }

    }

    private static void printList(Node head)
    {
        Node cur = head;
        while(cur != null)
        {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
    }
    private static Node sorted(Node a,Node b)
    {
        if(a== null)
            return b;
        if(b == null)
            return a;
        Node result = null;
        if(a.data<b.data)
        {
            result = a;
            result.next = sorted(a.next,b);
        }
        else
        {
            result = b;
            result.next = sorted(a,b.next);
        }

        return result;
    }

    public static void main(String[] args) {
        insert(1,4);
        insert(1,2);
        insert(1,0);

        insert(2,5);
        insert(2,3);
        insert(2,1);

        printList(head);
        System.out.println();
        printList(head2);

        Node sorted = sorted(head,head2);
        System.out.println();
        printList(sorted);
    }
}
