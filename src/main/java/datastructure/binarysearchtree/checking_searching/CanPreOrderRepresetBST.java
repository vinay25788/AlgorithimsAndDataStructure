package datastructure.binarysearchtree.checking_searching;

import java.util.Stack;

public class CanPreOrderRepresetBST {
    public static void main(String[] args) {
        int[] pre1 = new int[]{40, 30, 35, 80, 100};
        int n = pre1.length;
        if(canRepresetBst(pre1,n))
        {
            System.out.println(" yes ");
        }
        else
            System.out.println(" no");
    }

    public static boolean canRepresetBst(int[] pre,int n)
    {
        Stack<Integer> st = new Stack<>();
        int root = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(pre[i]< root)
                return false;
            while(!st.isEmpty() && st.peek()<pre[i])
                root = st.pop();
            st.push(pre[i]);
        }
        return true;
    }
}
