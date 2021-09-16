package practice.binarytree;

public class MaximumPathSumBetweenTwoLeafNode {

    static Node root;
        static Res res;
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

    static class Res
    {
         int res=0;
    }


    private int maxPathSum(Node root)
    {
        Res res = new Res();
        util(root,res);
        return res.res;

    }
    private int util(Node root,Res res)
    {
        if(root == null)
            return 0;
        if(root.left == null  && root.right == null)
            return root.data;
        int ls = util(root.left,res);
        int rs = util(root.right,res);

        if(root.left !=null && root.right != null )
        {
            res.res = Math.max(res.res,ls+rs+root.data);
            return Math.max(rs,ls)+root.data;
        }

        return root.left == null ? rs+root.data : ls+root.data;


    }

    public static void main(String[] args) {
        MaximumPathSumBetweenTwoLeafNode tree = new MaximumPathSumBetweenTwoLeafNode();
        tree.root = new Node(-15);
        tree.root.left = new Node(5);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(-8);
        tree.root.left.right = new Node(1);
        tree.root.left.left.left = new Node(2);
        tree.root.left.left.right = new Node(6);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(9);
        tree.root.right.right.right = new Node(0);
        tree.root.right.right.right.left = new Node(4);
        tree.root.right.right.right.right = new Node(-1);
        tree.root.right.right.right.right.left = new Node(10);

        System.out.println("Max pathSum of the given binary tree is " + tree.maxPathSum(root));
    }
}
