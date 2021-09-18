package practice.binarysearchtree;

import java.util.Arrays;

public class ConstructBSTFromPreOrder {

    static class Node
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
    static Node root;
    public static void main(String[] args) {
        int pre[] = { 100, 20, 10, 30, 200, 150, 300 };
      Node root=  constructBST(pre);
        System.out.println("inorder");
      inOrder(root);
    }
    private static void inOrder(Node root)
    {
        if(root != null)
        {
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
    private static Node constructBST(int[] pre)
    {
        int n = pre.length;
        int[] in =new int[n];
        for(int i=0;i<n;i++)
            in[i] = pre[i];
        Arrays.sort(in);
        System.out.println(Arrays.toString(in));
      return  constructBstUtil(in,pre,0,n-1);
    }
    static int preIndex =0;
    private static Node constructBstUtil(int[] in,int[] pre,int instart,int inEnd)
    {
        if(instart>inEnd)
            return null;
        Node node = new Node(pre[preIndex++]);

        if(instart == inEnd)
            return node;

             int index = search(in,instart,inEnd,node.data);




        node.left = constructBstUtil(in,pre,instart,index-1);


        node.right = constructBstUtil(in,pre,index+1,inEnd);

        return node;
    }

    private static int search(int[] in,int l,int h,int ele)
    {
        if(l>h)
            return -1;
        int mid = (l+h)/2;
        if(in[mid] == ele)
            return mid;
        if(ele>in[mid])
            return search(in,mid+1,h,ele);
        else
            return search(in,l,mid-1,ele);
    }
}
