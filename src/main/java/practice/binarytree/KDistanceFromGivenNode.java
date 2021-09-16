package practice.binarytree;

import java.util.ArrayList;
import java.util.List;

public class KDistanceFromGivenNode {

    static Node root;
    static List<Node> path;

    static class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static void printNode(Node root,Node target,int k)
    {

        path = new ArrayList<>();

        findAllPath(root,target);
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<path.size();i++)
        {
            findKDistnace(path.get(i), k-i,result,i==0 ? null:path.get(i));
        }

        System.out.println(result);

    }

    private static void findKDistnace(Node node,int dist, List<Integer> res,Node blocker )
    {
        if(dist<0 || node == null || blocker != null && node == blocker)
            return;

        if(dist == 0)
            res.add(node.data);
        findKDistnace(node.left,dist-1,res,blocker);
        findKDistnace(node.right,dist-1,res,blocker);
    }

    static private boolean findAllPath(Node root,Node target)
    {
        if(root == null)
            return false;
        if(root == target || findAllPath(root.left, target) || findAllPath(root.right,target))
        {
            path.add(root);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(3);
        root.left.left = new Node(4);
        root.right = new Node(5);
        root.right.right = new Node(6);
        root.right.left = new Node(7);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);
        printNode(root,root.right.left.left,3);
    }
}
