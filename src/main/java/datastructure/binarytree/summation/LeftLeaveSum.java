package datastructure.binarytree.summation;

public class LeftLeaveSum {
    public static int sum = 0;

    public static void leftSum(Node root, boolean isLeft) {
        if (root == null)
            return;
        if (root.left == null && root.right == null && isLeft)
            sum += root.data;
        leftSum(root.left, true);
        leftSum(root.right, false);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        leftSum(root, true);
        System.out.println(" total left sum " + sum);

    }
}
