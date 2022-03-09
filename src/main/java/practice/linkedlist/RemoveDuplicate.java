package practice.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicate {
    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
static Node head;
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(Arrays.toString(list.toArray()));

        head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);

        removeDuplicate();

        Node temp = head;
        while(temp !=null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }

    }

    private static void removeDuplicate ()
    {
        Node temp = head.next;
        Node prev = head;

        while(temp != null)
        {
            while(temp.next != null && temp.data == prev.data)
            {
                temp = temp.next;
            }
              if(temp.next != null) {
                  prev.next = temp;
                  prev = temp;
                  temp = temp.next;
              }
              else
              {
                  prev.next = null;
                temp = temp.next;


              }

        }

    }
}
