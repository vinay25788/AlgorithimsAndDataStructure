package datastructure.binarytree.lowest_common_ancestor;

public class DistanceBetweenTwoNode {



    public static Node findLCA(Node root ,int a,int b)
    {
        if(root == null)
            return null;
        if(root.data == a  || root.data == b)
            return root;

        Node leftLCA = findLCA(root.left,a,b);
        Node rightLCA = findLCA ( root.right,a,b);
        if(leftLCA != null && rightLCA != null)
            return root;
        if(leftLCA == null && rightLCA == null )
            return null;

        return leftLCA != null ? leftLCA : rightLCA;
    }

    public static int findLevel(Node root,int a, int level)
    {
        if(root == null)
            return -1;
        if(root.data == a)
            return level;
        int leftLevel = findLevel(root.left,a, level+1) ;
        if(leftLevel == -1)
            return findLevel(root.right , a, level+1);
        return leftLevel;
    }


    public static int findDistance(Node root,int a,int b)
    {
        Node lca = findLCA ( root, a, b);
        int d1 = findLevel(lca,a,0);
        int d2 = findLevel(lca,b,0);
        return d1+d2;
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
        int  distance = findDistance(root, 2,4);
        System.out.println(" distance between both the node "+distance);

    }


}
