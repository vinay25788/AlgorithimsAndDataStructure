package practice.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConvertListToBT {

    ListNode head;
    BTNode root;

    static class ListNode
    {
        int data;
        ListNode next;

        ListNode(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    class BTNode
    {
        int data;
        BTNode left,right;

        BTNode(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private BTNode listToBt(ListNode head, BTNode btNode)
    {
        Queue<BTNode> que = new LinkedList<>();

        if(head == null)
            return null;
        btNode = new BTNode(head.data);

        que.add(btNode);
        head = head.next;
        while(head != null)
        {
            BTNode parent = que.peek();
            que.poll();
            BTNode leftChild = null,rightChild = null;
            if(head != null)
            {
                 leftChild = new BTNode(head.data);
                que.add(leftChild);

            }
            head = head.next;
            if(head != null)
            {
                rightChild = new BTNode(head.data);
                que.add(rightChild);
                head = head.next;

            }
            parent.left = leftChild;
            parent.right = rightChild;


        }

        return btNode;

    }

    private static void inOrder(BTNode root)
    {
        if(root != null)
        {
            inOrder( root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
    public static void main(String[] args) {
        ConvertListToBT obj = new ConvertListToBT();
        obj.head = new ListNode(36);
       obj.head.next  = new ListNode(30); /* Last node of Linked List */
      obj.head.next.next  = new ListNode(25);
        obj.head.next.next.next = new ListNode(15);
        obj.head.next.next.next .next = new ListNode(20);
        obj.head.next.next.next .next.next = new ListNode(10);

       BTNode node =  obj.listToBt(obj.head,obj.root);
        System.out.println(obj.root);
        inOrder(node);
    }
}
