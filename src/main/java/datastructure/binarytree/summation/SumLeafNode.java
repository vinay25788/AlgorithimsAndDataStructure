package datastructure.binarytree.summation;

import java.util.LinkedList;
import java.util.Queue;

public class SumLeafNode {
    static int sum;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node (2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(5);
        findSum(root);
        System.out.println(sum);
        System.out.println(" using iterative ");
        sum =0;
        findSumUsingQueue(root);
        System.out.println(sum);
    }
    public static void findSumUsingQueue(Node root)
    {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty())
        {
            Node temp = que.remove();
            if(temp.left == null && temp.right == null)
                sum+=temp.data;
            else
            {
                que.add(temp.left);
                que.add(temp.right);
            }
        }
    }

    public static void findSum(Node root)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            sum+=root.data;
         findSum(root.left);
         findSum(root.right);
    }
}
