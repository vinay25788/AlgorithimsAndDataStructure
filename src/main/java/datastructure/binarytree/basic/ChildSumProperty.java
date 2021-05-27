package datastructure.binarytree.basic;

public class ChildSumProperty {
    Node root;

    public int isSumProperty(Node root)
    {
        int leftData=0,rightData =0;
        if(root == null || (root.left == null && root.right == null))
            return 1;
        else
        {
            if(root.left != null)
                leftData = root.left.data;
            if(root.right != null)
                rightData = root.right.data;


            if((root.data == (leftData+rightData) || ((isSumProperty(root.left) != 0) && (isSumProperty(root.right) !=0)) ))
                return 1;
            else
                return  0;
        }
    }

    public void inOrder(Node root)
    {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        ChildSumProperty tree = new ChildSumProperty();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(2);
        if (tree.isSumProperty(tree.root) != 0)
            System.out.println("The given tree satisfies children"
                    + " sum property");
        else
            System.out.println("The given tree does not satisfy children"
                    + " sum property");
    }
}
