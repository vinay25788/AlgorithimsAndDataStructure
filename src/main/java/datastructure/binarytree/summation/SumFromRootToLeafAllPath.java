package datastructure.binarytree.summation;

class Sum
{
    int sum;
}
public class SumFromRootToLeafAllPath {

    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val)
        {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
  static public int sumNumbers(TreeNode root) {
        Sum sum = new Sum();
        solve(root,0,sum);
        return sum.sum;
    }

    static public void solve(TreeNode root,int curSum,Sum sum)
    {
        if(root == null)
            return;
        curSum =curSum*10+root.val;
        if(root.left == null && root.right == null)
        {
            sum.sum += curSum;
        }
        solve(root.left,curSum,sum);
        solve(root.right,curSum,sum);

        //curSum -=root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));
    }
}
