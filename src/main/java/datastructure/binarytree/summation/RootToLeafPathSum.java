package datastructure.binarytree.summation;

public class RootToLeafPathSum {
    static int sum=0;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node (2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(5);
        System.out.println(hasPathSum(root,30));
    }
    public static boolean hasPathSum(Node root,int sum)
    {
        if(root == null)
            return sum ==0;
        return hasPathSum(root.left,sum-root.data) || hasPathSum(root.right,sum-root.data);
    }


}
