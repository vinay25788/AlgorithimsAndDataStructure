package practice.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraversal {

    static Node root;

    static class Node
    {
        int data;
        Node left,right;

        Node(int data)
        {
            this.data =data;
            this.left = null;
            this.right = null;
        }
    }

    private static void diagonalTraversal(Node root)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();
        diagonalUtil(root,map,0);
        for(Map.Entry<Integer,List<Integer>> entry: map.entrySet())
        {
            System.out.println(entry.getValue());
            System.out.println();
        }
    }
    private static void diagonalUtil(Node root,Map<Integer,List<Integer>> map,int dis)
    {
        if(root == null)
            return;

        List<Integer> list = map.get(dis);
        if(list == null)
        {
            list = new ArrayList<>();
        }
        list.add(root.data);
        map.put(dis,list);

        diagonalUtil(root.left,map,dis);
        diagonalUtil(root.right,map,dis+1);


    }
    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        diagonalTraversal(root);
    }
}
