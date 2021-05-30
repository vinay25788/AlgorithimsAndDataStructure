package datastructure.binarytree.summation;

public class CountSubTreeWithGivenX {
    static int count;
    static int countUsingRecursion;
    static Node ptr;
    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(-10);
        root.right = new Node(3);
        root.left.left = new Node(9);
        root.left.right = new Node(8);
        root.right.left = new Node(-4);
        root.right.right = new Node(7);
        int x =7;
        countSubtreeWithGivenX(root,x);
        countSubtreeWithGivenXRecursion(root, x);
        System.out.println(" max sum using recursion ");
        sumOfMaxDepth(root);
    }
    public static int countSubtreeWithGivenXRecursion(Node root,int x)
    {
        int l =0,r =0;
        if(root == null)
            return 0;
        l +=countSubtreeWithGivenXRecursion(root.left,x);
        r+= countSubtreeWithGivenXRecursion(root.right,x);
        if(l+r+root.data==x)
            countUsingRecursion++;
        if(ptr!=root)
         return l+root.data+r;
        return count;

    }
    public static void countSubtreeWithGivenX(Node root,int x)
    {
        if(root == null)
            return;
        int ls = countSubtreeWithGivenXUtil(root.left,count,x);
        int rs = countSubtreeWithGivenXUtil(root.right,count,x);
        if(ls+rs+root.data==x)
            count++;
        System.out.println("count of subtree "+count);
    }

    public static void sumOfMaxDepth(Node root)
    {
        int depth = maxDepthLevel(root);
        int sum = sum(root,depth);
        System.out.println(sum);
    }
    public static int sum(Node root,int depth)
    {
        if(root == null)
            return 0;
        if(depth == 1)
            return root.data;
        return sum(root.left,depth-1)+sum(root.right,depth-1);
    }

    public static int maxDepthLevel(Node root)
    {
        if(root == null)
            return 0;
        return 1+Math.max(maxDepthLevel(root.left),maxDepthLevel(root.right));
    }

    public static int countSubtreeWithGivenXUtil(Node root,int count,int x)
    {
        if(root == null)
            return 0;
        int ls = countSubtreeWithGivenXUtil(root.left,count,x);
        int rs = countSubtreeWithGivenXUtil(root.right,count,x);
        if(ls+rs+root.data==x)
            count++;
        return  ls+rs+root.data;

    }
}
