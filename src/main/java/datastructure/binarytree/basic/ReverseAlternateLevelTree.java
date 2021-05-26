package datastructure.binarytree.basic;

public class ReverseAlternateLevelTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        reverseAlternate(root);
        inorder(root);
    }
    public static void reverseAlternate(Node root)
    {
         preOrder(root.left,root.right,0);
    }
    public static void preOrder(Node root1,Node root2,int level)
    {
        if(root1 == null || root2 == null)
            return;
        if(level %2 == 0)
        {
            int temp = root1.data;
            root1.data = root2.data;
            root2.data = temp;

        }
        preOrder(root1.left,root2.right,level+1);

        preOrder(root1.right, root2.left,level+1 );
    }
    public static void inorder(Node root)
    {
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}
