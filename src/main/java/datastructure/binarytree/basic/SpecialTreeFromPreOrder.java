package datastructure.binarytree.basic;

public class SpecialTreeFromPreOrder {
    static BNode root=null;

    static Index myIndex = new Index();

    static class Index
    {
        int index=0;
    }

   static class BNode
    {
        int data;
        BNode left = null, right = null;

        BNode(int data)

        {
            this.data = data;
        }
    }
    public static BNode constructSpecialTree(int[] pre,char[] preLN,int n,Index myIndex,BNode temp)
    {
        int index =myIndex.index;
        BNode tNode = new BNode(pre[index]);
        myIndex.index++;
        if(index == n)
            return null;
        if(preLN[index] =='N')
        {
            tNode.left = constructSpecialTree(pre,preLN,n,myIndex,tNode.left);
            tNode.right = constructSpecialTree(pre,preLN,n,myIndex,tNode.right);

        }
        return temp;
    }

    public static void preOrder(BNode root)
    {
        if(root == null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        int pre[] = new int[]{10, 30, 20, 5, 15};
        char preLN[] = new char[]{'N', 'N', 'L', 'L', 'L'};
        int n = pre.length;

       BNode temp =  constructSpecialTree(pre,preLN,n,myIndex,root);
       preOrder(temp);

    }

}
