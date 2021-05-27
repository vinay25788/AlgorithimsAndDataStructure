package datastructure.binarytree.basic;

import java.util.LinkedList;
import java.util.List;

public class PathFromNodeAtDistanceK {
    static List<Node> path = null;
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        Node target = root.left.right;
        System.out.println(distanceK(root,target,2));
    }
    public static List<Integer>  distanceK(Node root,Node target,int d)
    {
        path = new LinkedList<>();

        findPath(root,target);

        List<Integer> result = new LinkedList<>();
        for(int i=0;i<path.size();i++)
        {
            findKDistanceFromNode(path.get(i),d-i,result, i==0?null:path.get(i-1));
        }

        return result;

    }

    public static void findKDistanceFromNode(Node node ,int dist, List<Integer> result, Node blocker)
    {
        if(dist<0 || node == null || (blocker != null && blocker == node))
        {
            return;
        }
        if(dist == 0)
            result.add(node.data);
        findKDistanceFromNode(node.left,dist-1,result, blocker);
        findKDistanceFromNode(node.right, dist-1,result,blocker);
    }

    public static boolean findPath(Node root, Node target)
    {
        if(root == null)
            return false;
        if(root == target || findPath(root.left,target) || findPath(root.right,target))
        {
            path.add(root);
            return true;
        }
        return false;

    }
}
