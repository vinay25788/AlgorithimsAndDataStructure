package practice.binarytree;
/*
       6
       /      \
     3          5
   /   \          \
  2     5          4
      /   \
     7     4
  There are 4 leaves, hence 4 root to leaf paths:
   Path                    Number
  6->3->2                   632
  6->3->5->7               6357
  6->3->5->4               6354
  6->5>4                    654
Answer = 632 + 6357 + 6354 + 654 = 13997
 */
public class SumNumberFromRootToLeaf {

    static Node root;

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
    private static int diagonalSum()
    {
        return util(root,0);
    }
    private static int util(Node root,int val)
    {
        if(root == null)
            return 0;
        val = val*10 + root.data;
        if(root.left == null && root.right == null)
            return val;
        return util(root.left,val)+util(root.right ,val);
    }

    public static void main(String[] args) {

        root = new Node(1);
        root.left= new Node(2);
        root.right = new Node(3)    ;
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        System.out.println(diagonalSum());
    }
}
