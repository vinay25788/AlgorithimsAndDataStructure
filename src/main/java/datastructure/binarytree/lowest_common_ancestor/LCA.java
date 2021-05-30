package datastructure.binarytree.lowest_common_ancestor;

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
public class LCA {
    static boolean v1,v2;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node (3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node lca = findLCA(root, 4,5);
        if(lca != null)
            System.out.println(lca.data);
        else
            System.out.println("keys are not present");
    }
    public static Node findLCA(Node root, int n1,int n2)
    {
        v1 = false;
        v2 = false;

        Node node = findLCAUtil(root,n1,n2);
        if(v1&&v2)
            return node;
        return null;

    }
    public static Node findLCAUtil(Node root,int n1,int n2)
    {
        if(root == null)
            return null;
        Node temp = null;
        if(root.data == n1)
        {
            temp = root;
            v1 = true;
        }
        if(root.data == n2)
        {
            temp = root;
            v2 = true;
        }
         Node leftLCA= findLCAUtil(root.left,n1,n2);
        Node rightLCA = findLCAUtil(root.right,n1,n2);
        if(temp != null)
            return temp;

        if( leftLCA != null && rightLCA != null)
            return root;

        return leftLCA != null ? leftLCA:rightLCA;

    }
}
