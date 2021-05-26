package datastructure.binarytree.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalPrint {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        printDiagonal(root);
    }
    public static void printDiagonal(Node root)
    {
        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();
        printDiagonalUtil(root,0,diagonalMap);
        for(Map.Entry<Integer,List<Integer>> entry:diagonalMap.entrySet())
        {
            System.out.println(entry.getValue());
        }
    }
    public static void printDiagonalUtil(Node root, int d,Map<Integer,List<Integer>> diagonalMap)
    {
        if(root == null)
            return;
        List<Integer> list = diagonalMap.get(d);
        if(list == null)
        {
            list = new ArrayList<>();
            list.add(root.data);
        }
        else
            list.add(root.data);
        diagonalMap.put(d,list);

        printDiagonalUtil(root.left,d+1,diagonalMap);
        printDiagonalUtil(root.right,d,diagonalMap);
    }

}
