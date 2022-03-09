package datastructure.twopointer;

public class AlternateNodeInLinkedList {


    static public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    static  public ListNode reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        ListNode prev = null;

        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

        }

        prev.next = null;

        ListNode secondHalf = slow;

        ListNode reversedHalf = reverse(secondHalf);

        print(head);
        System.out.println();
        print(reversedHalf);


        return  merge(head,reversedHalf);

    }

   static  public void print(ListNode head)
    {
        ListNode temp = head;
        while(temp != null)
        {
            System.out.print(" "+temp.val);
            temp = temp.next;
        }
    }

   static public ListNode merge(ListNode a,ListNode b)
    {
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        while(a != null && b != null)
        {
            if(a != null)
            {
                ListNode nextA = a.next;

                dummy.next = a;

              a = nextA;

              dummy = dummy.next;

            }
            if(b!= null)
            {
                ListNode nextB = b.next;

                dummy.next = b;

              b = nextB;
            dummy = dummy.next;
            }





        }

        return newHead;

    }

   static public ListNode reverse(ListNode head)
    {
        ListNode cur = head;
        ListNode next = null;
        ListNode prev = null;

        while(cur != null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode( 4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode node = reorderList(head);

        System.out.println();
        print(node);
    }
}
