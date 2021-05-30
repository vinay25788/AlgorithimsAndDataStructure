package datastructure.binarytree.summation;

public class SumNumberFormedRootLeafPath {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node (2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(5);
        System.out.println(sumFormed(root));
    }
    public static int sumFormed(Node root)
    {
        return sumFromRootToLeaf(root,0);
    }
    public static int sumFromRootToLeaf(Node root,int value)
    {
        if(root == null)
            return 0;
        value = value*10+root.data;
        if(root.left == null && root.right == null)
            return value;

        return sumFromRootToLeaf(root.left,value) + sumFromRootToLeaf(root.right,value);
    }
}
