package datastructure.binarytree.basic;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("height of the tree "+calculateHeight(root));
    }
    public static int calculateHeight(Node root)
    {
        if(root == null)
            return 0;
        int lheight = calculateHeight(root.left);
        int rHeight = calculateHeight(root.right);
        if(lheight>rHeight)
            return lheight+1;
        else
            return rHeight+1;

    }
}
