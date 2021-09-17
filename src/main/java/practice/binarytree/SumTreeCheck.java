package practice.binarytree;

/*
      26
        /   \
      10     3
    /    \     \
  4      6      3
 */
public class SumTreeCheck {

    static class Node
    {
        int data;
        Node left ,right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static Node root;
    public static void main(String[] args) {
        root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);

        System.out.println(isSumTree(root));
    }
    private static int sum(Node root)
    {
        if(root == null)
            return 0;
        return sum(root.left)+sum(root.right) + root.data;
    }
    private static int isSumTree(Node root)
    {
        if(root == null)
            return 1;
        int ls ,rs;
        if(root == null || ( root.left == null && root.right == null))
            return 1;
        ls = sum(root.left);
        rs = sum(root.right);
        if(root.data == ls+rs && isSumTree(root.left) != 0 && isSumTree(root.right) != 0)
            return 1;
        return 0;
    }
}
