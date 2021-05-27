package datastructure.binarytree.basic;

public class CheckPerfectBinaryTree {

    Node root;


    public static int findDepth(Node root)
    {
        int d=0;
        while(root != null)
        {
            d++;
            root = root.left;
        }
        return d;
    }
    public static boolean check(Node root,int d,int level)
    {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return d == level+1;
        if(root.left == null || root.right == null)
            return false;
        return check(root.left,d,level+1) && check(root.right,d,level+1);
    }

    public static  boolean checkPerfectTree(Node root)
    {
        int d = findDepth(root);
        return check(root,d,0);
    }

    public static void main(String[] args) {
        CheckPerfectBinaryTree tree = new CheckPerfectBinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(8);
        tree.root.right.right = new Node(9);

        if(checkPerfectTree(tree.root))
        {
            System.out.println("Binary tree is perfect tree");
        }
        else
            System.out.println("Not perfect tree");
    }
}
