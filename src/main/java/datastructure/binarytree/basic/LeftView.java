package datastructure.binarytree.basic;

import java.util.*;

public class LeftView {
     static int maxLevel=0;
    static class QueueNode
    {
        int dist;
        Node node;
        QueueNode(int dist,Node node)
        {
            this.dist = dist;
            this.node = node;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        printLeftView(root,1);
        System.out.println(" using queue");
        System.out.println();
        printLeftViewUsingQueue(root);
        System.out.println("top view");
        topView(root);
    }

    public static void topView(Node root)
    {
       Queue<QueueNode> que = new LinkedList<>();
       que.add(new QueueNode(0,root));
        Map<Integer, Node > map = new HashMap<>();
        while(!que.isEmpty())
        {
            QueueNode temp = que.remove();
            int hd = temp.dist;
            Node tnode = temp.node;

            if(!map.containsKey(hd))
                map.put(hd,tnode);

            if(tnode.left != null)
                que.add(new QueueNode(hd-1,tnode.left));
            if(tnode.right != null)
                que.add(new QueueNode(hd+1, tnode.right));
        }
        for(Map.Entry<Integer,Node> entry:map.entrySet())
        {
            System.out.print(entry.getValue().data+" ");
        }
    }

    public static void printLeftViewUsingQueue(Node root)
    {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty())
        {
            int size = que.size();

            for(int i=1;i<=size;i++)
            {
                Node temp = que.remove();
                if(i==1)
                System.out.print(temp.data+" ");
                if(temp.left != null)
                    que.add(temp.left);
                if(temp.right != null)
                    que.add(temp.right);
            }


        }
    }
    public static void printLeftView(Node root,int level)
    {
        if(root == null)
            return;
        if(maxLevel<level)
        {
            System.out.print(root.data+" ");
            maxLevel = level;
        }
        printLeftView(root.left,level+1);
        printLeftView(root.right,level+1);

    }
}
