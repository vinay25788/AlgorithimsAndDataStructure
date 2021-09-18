package practice.linkedlist;

public class NthNodeFromTheEnd {

    static Node head;

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

   private static void insert(int key)
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

   private static void printList()
   {
       Node temp = head;
       while(temp != null)
       {
           System.out.print(temp.data+" ");
           temp = temp.next;
       }
   }

   private static void printNthFromEnd(int nth)
   {
       Node mainRef = head;
       int count =0;
       while(count<nth)
       {
           if(mainRef!= null)
           {
               mainRef = mainRef.next;
           }
           count++;

       }
       if(mainRef == null)
       {
           System.out.println("no of node is less than "+nth);
           return;
       }
       Node ref = head;
       while(mainRef != null)
       {
           ref = ref.next;
           mainRef = mainRef.next;
       }
       System.out.println("nth node from end "+ref.data);
   }
    public static void main(String[] args) {
        insert(1);
        insert(2    );
        insert(3);
        insert(4);
        insert(5);
        printList();
        System.out.println();
        printNthFromEnd(6);
    }
}
