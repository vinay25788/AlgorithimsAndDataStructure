package datastructure.binarytree.misc;

public class MaxDepth {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println(findDepth(root));

    }
    public static int findDepth(Node root)
    {
        if(root == null)
            return 0;
        else {
            int ldepth = findDepth(root.left);
            int rdepth = findDepth(root.right);
            if(ldepth>rdepth)
                return ldepth+1;
            else
                return rdepth+1;
        }
    }
}
