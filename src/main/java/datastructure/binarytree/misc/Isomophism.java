package datastructure.binarytree.misc;

class Node
{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class Isomophism {
    public static boolean checkIsomorphic(Node root1,Node root2)
    {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if((checkIsomorphic(root2.left,root2.left)&& checkIsomorphic(root1.right,root2.right))
            || (checkIsomorphic(root1.left,root2.right) && checkIsomorphic(root1.right,root2.left)))
            return true;
        return false;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);
        root2.right.left.right = new Node(8);
            if(checkIsomorphic(root,root2))
            {
                System.out.println(" Isomorhphic ");
            }
            else
                System.out.println(" not isomorphic");
    }
}
