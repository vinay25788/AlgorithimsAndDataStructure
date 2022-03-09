package datastructure.twopointer;


public class LinkeListCircle {

    static class ListNode
    {
        int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    static public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                break;
            }
        }

        ListNode temp = slow;

        if(temp != head)
        {
            while(temp != fast)
            {
                temp = temp.next;
                fast = fast.next;

            }
            return temp;
        }
        else
            return temp;


    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next = head.next;
        System.out.println(detectCycle(head).val);
    }
}
