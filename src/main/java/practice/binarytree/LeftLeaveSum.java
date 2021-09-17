package practice.binarytree;

public class LeftLeaveSum {

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

    static class Sum
    {
        int total;
    }
      Node root;
      Sum sum;

    public static void main(String[] args) {
        LeftLeaveSum tree = new LeftLeaveSum();
        tree.root = new Node(20);
        tree.root.left = new Node(9);
        tree.root.right = new Node(49);
        tree.root.left.right = new Node(12);
        tree.root.left.left = new Node(5);
        tree.root.right.left = new Node(23);
        tree.root.right.right = new Node(52);
        tree.root.left.right.right = new Node(12);
        tree.root.right.right.left = new Node(50);

        System.out.println(" left leave sum "+leftLeaveSum(tree.root));
    }

    private static int leftLeaveSum(Node root)
    {
        Sum sum = new Sum();
         util(root,sum,false);
         return sum.total;
    }
    private static void util(Node root,Sum sum,boolean isLeft)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null & isLeft)
            sum.total += root.data;
        util(root.left,sum,true);
        util(root.right,sum,false);


    }
}
