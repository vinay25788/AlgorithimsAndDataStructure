package practice.binarytree;

/*
    1

    /   \
    2      3
    /\     \
    4 5     6
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalSum {

   static  Node root;

    static class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

   void  diagonalSum(Node root)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();
        util(root,map,0);
        System.out.println(map);
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet())
        {
            int sum =0;
            for(int el:entry.getValue())
                sum+= el;
            System.out.println(sum);
        }
    }
    private static void util(Node root,Map<Integer,List<Integer>> map,int dis)
    {
        if(root == null)
            return;

        List<Integer> list = map.get(dis);
        if(list == null)
            list = new ArrayList<>();
        list.add(root.data);
        map.put(dis,list);
        util(root.left,map,dis-1);
        util(root.right,map,dis);

    }

    public static void main(String[] args) {

        root = new Node(1);
        root.left= new Node(2);
        root.right = new Node(3)    ;
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        DiagonalSum obj = new DiagonalSum();
        obj.diagonalSum(obj.root);
    }
}
