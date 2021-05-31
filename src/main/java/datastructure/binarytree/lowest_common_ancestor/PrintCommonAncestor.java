package datastructure.binarytree.lowest_common_ancestor;

public class PrintCommonAncestor {

    public static void printCommonNodes(Node root,int a,int b)
    {
        Node lca = findLCA(root,a,b);
        if(lca == null)
        {
            System.out.println(" no common ancestor ");
            return;
        }
        printCommonAncenstor(root,lca.data);
    }
    public static Node findLCA(Node root, int a, int b)
    {
        if(root == null)
            return null;
        if(root. data == a || root.data == b)
            return root;
        Node left = findLCA(root.left,a,b);
        Node right = findLCA(root.right,a,b);
        if(left != null && right != null)
            return root;
        if(left == null && right == null)
            return null;
        return left != null ? left : right;
    }
    public static boolean printCommonAncenstor(Node root, int target)
    {

        if(root == null)
            return false;
        if(root.data == target)
        {
            System.out.print(root.data +" ");
            return true;
        }
        if(printCommonAncenstor(root.left,target) || printCommonAncenstor(root.right,target))
        {
            System.out.print(root.data+" ");
            return true;
        }
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
        root.left.left.left = new Node(8);
        root.right.left.left = new Node(9);
        root.right.left.right = new Node(10);

        printCommonNodes(root, 10,9);

    }
}
