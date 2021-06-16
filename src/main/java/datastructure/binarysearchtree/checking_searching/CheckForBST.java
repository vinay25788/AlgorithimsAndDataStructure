package datastructure.binarysearchtree.checking_searching;

public class CheckForBST {
    static Node prev;
    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(10);
        System.out.println(isBstR(root,null,null));
    }

    public static boolean isBstR(Node root,Node l,Node r)
    {
        if(root == null)
            return true;
        if(l != null && root.data<=l.data)
            return false;
        if(r!= null && root.data>= r.data)
            return false;
        return isBstR(root.left, l,root) && isBstR(root.right,root,r);
    }
}
