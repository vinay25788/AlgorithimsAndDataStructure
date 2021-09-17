package practice.binarytree;

public class DistanceBetweenTwoNode {
    static class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right  = null;
        }
    }
    static Node root;

    private static Node findLCA(Node root,int n1,int n2)
    {
        if(root == null)
            return null;
        if(root.data == n1 || root.data == n2)
            return root;
        Node left = findLCA(root.left,n1,n2);
        Node right = findLCA(root.right,n1,n2);
        if(left != null && right != null)
            return root;
        return left != null ? left:right;
    }
    private static int findLevel(Node root,int a,int level)
    {
        if(root == null)
            return 0;
        if(root.data == a)
            return level;
       int left =  findLevel(root.left,a,level+1);
       if(left !=0)
           return left;
      return  findLevel(root.right,a,level+1);

    }
    private static void findDistance(Node root,Node n1,Node n2)
    {
        Node lca = findLCA(root,n1.data,n2.data);
        int d = findLevel(lca,n1.data,0);
        int d2 = findLevel(lca,n2.data,0);
        System.out.println(d+d2);

    }
    public static void main(String[] args) {
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        findDistance( root,root.left.left,root.right.left);
    }
}
