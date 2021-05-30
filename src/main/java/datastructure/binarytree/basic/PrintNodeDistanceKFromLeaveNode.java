package datastructure.binarytree.basic;

public class PrintNodeDistanceKFromLeaveNode {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.left.right = new Node(6);
        int k =2;
        printDistanceKFromLeave(root,k);
    }
    public static void printDistanceKFromLeave(Node root,int k)
    {
        int[] path = new int[100];
        boolean[] visited = new boolean[100];
        pathDistanceKFromLeaveUtil(root,path,visited,k,0);
    }
    public static void pathDistanceKFromLeaveUtil(Node root,int[] path,boolean[] visited,int k,int pathlen )
    {
        if(root == null)
            return;
        path[pathlen] = root.data;
        visited[pathlen] = false;
        pathlen++;

        if(root.left == null && root.right == null && pathlen-k-1>0 && visited[pathlen-k-1]==false)
        {
            System.out.print(path[pathlen-k-1]+" ");
            visited[pathlen-k-1] = true;
            return;
        }
        pathDistanceKFromLeaveUtil(root.left,path,visited,k,pathlen);
        pathDistanceKFromLeaveUtil(root.right,path,visited,k,pathlen);
    }
}
