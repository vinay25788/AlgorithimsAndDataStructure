package datastructure.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderBinary {

    static class TreeNode
    {
        int val;
        TreeNode left,right;

        TreeNode(int val)
        {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static  public List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> que = new LinkedList<>();
        List<Double> list = new ArrayList<>();

        if(root == null)
            return list;

        que.add(root);


        while(!que.isEmpty())
        {
            int size = que.size();

            double sum=0.0;

            int numberOfNode = size;

            while(size>0)
            {
                TreeNode temp = que.poll();

                sum += temp.val;
                if( temp.left != null)
                    que.add(temp.left);
                if( temp.right != null)
                    que.add(temp.right);
                size--;
            }

            list.add(sum/numberOfNode);


        }
        return list;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);
        System.out.println(averageOfLevels(root));
    }

}
