package datastructure.binarytree.basic;

public class ReversalLevelOrderUsingRecursion {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        reverse(root);
    }
    public static void reverse(Node root)
    {
        int h = height(root);
        int i;
        for(i=h;i>=1;i--)
        {
            printLevelOrder(root,i);
        }
    }

    public static void printLevelOrder(Node root , int level)
    {
        if(root == null)
            return;
        if(level == 1)
            System.out.print(" "+root.data);
        else
        {
            printLevelOrder(root.left,level-1);
            printLevelOrder(root.right,level-1);

        }
    }

    public static int height(Node root)
    {
        if(root == null)
            return 0;
        else
        {
            int lheight = height(root.left);
            int rheight = height(root.right);
            if(lheight>rheight)
                return lheight+1;
            else
                return rheight +1;
        }
    }
}
