package datastructure.binarytree.summation;

import java.util.LinkedList;
import java.util.Queue;

public class DifferenceBetweenOddAndEvenLevel {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(findSumDiffere(root));
    }

    public static int findSumDiffere(Node root) {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        int level =0;
        int evenSum=0,oddSum =0;
        while(!que.isEmpty())
        {
            int size = que.size();
            level++;
            while(size>0)
            {
                Node temp = que.remove();
                if(level%2==0)
                    evenSum+= temp.data;
                else
                    oddSum +=temp.data;
                if(temp.left != null)
                    que.add(temp.left);
                if(temp.right != null)
                    que.add(temp.right);
                size--;
            }
        }
        return evenSum-oddSum;

    }
}
