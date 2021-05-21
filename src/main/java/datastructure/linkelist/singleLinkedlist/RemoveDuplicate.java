package datastructure.linkelist.singleLinkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicate {

    Node head;
    public void add(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void print()
    {
        if(head == null)
        {
            System.out.println(" No element ");
            return;
        }
        Node temp = head;
        while(temp != null)
        {
            System.out.println(temp.data +" ");
            temp = temp.next;
        }
    }

public void removeDuplicate()
{
    Node temp = head;
    Map<Integer,Boolean> map = new HashMap<>();
    System.out.println(" duplicates present in list ");
    while(temp != null)
    {
        if(!map.containsKey(temp.data))
        {
            System.out.println(temp.data);
        }
        map.put(temp.data, true);
        temp = temp.next;
    }
}

public void removeDuplicateUsingSet()
{
    Node temp = head;
    Set<Integer> set = new HashSet<>();
    Node prev = null;
    while(temp != null)
    {
        if(set.contains(temp.data))
        {
            prev.next = temp.next;

        }
        else
        {
            set.add(temp.data);
            prev = temp;

        }
        temp =temp.next;
    }

}


    public static void main(String[] args) {
        RemoveDuplicate list = new RemoveDuplicate();
        list.add(1);
        list.add(2);
        list.add(2);list.add(3);

        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        System.out.println();
       // list.removeDuplicate();
        System.out.println("removed duplicates");
        list.removeDuplicateUsingSet();
        list.print();

    }
}
