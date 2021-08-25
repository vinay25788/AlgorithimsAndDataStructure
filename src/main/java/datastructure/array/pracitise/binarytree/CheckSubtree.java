package datastructure.array.pracitise.binarytree;

public class CheckSubtree {

   static class BNode
    {
        int data;
        BNode left,right;
        BNode(int data)
        {
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isSubtree(BNode T, BNode S)
    {
        if(T== null)
            return false;
        if(S == null)
            return true;
        if(areIdenticle(T,S))
            return true;
        return  isSubtree(T.left,S) || isSubtree(T.right,S);
    }

    public static boolean areIdenticle(BNode T, BNode S)
    {
        if(T == null && S == null)
            return true;
        if(S == null || T== null)
            return false;

        if(T.data == S.data && (areIdenticle(T.left, S.left) || (areIdenticle(T.right,S.left))))
            return true;
        return false;
    }

    public static void main(String[] args) {
        BNode T = new BNode(4);
        T.left = new BNode(5);
        T.left.right = new BNode(3);
        T.left.left = new BNode(2);

        BNode S = new BNode(5);
        S.right = new BNode(3);
        S.left = new BNode( 2);

        System.out.println(isSubtree(T,S));


    }
}
