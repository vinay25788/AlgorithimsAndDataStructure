package datastructure.linkelist;



public class clycleExist {

    static class Node
    {
        int val;
        Node next;

        Node(int val)
        {
            this.val = val;
            this.next = null;
        }
    }


    public static void cyclicNode(Node head)
    {
        Node slow = head;
        Node fast = head;

        boolean isCyclic = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCyclic = true;
                break;
            }
        }
          if(!isCyclic)
              return;
          else
          {
               slow = head;

               if(slow != fast)
               {
                   while(slow.next != fast.next)
                   {
                       slow = slow.next;
                       fast = fast.next;
                   }
                   fast.next = null;
               }
               else
               {
                   Node temp = slow;

                   while(temp.next != fast)
                   {
                       temp = temp.next;
                   }
                   temp.next = null;

               }


               Node temp = head;
               while(temp != null)
               {
                   System.out.println(temp.val+" ");
                   temp = temp.next;
               }

          }


        }






    public static void main(String[] args) {
        Node head = new Node(1);

        head.next = new Node (2);
        head.next.next = new Node ( 3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next;

        cyclicNode(head);

    }

}
