package datastructure.stack;

import java.util.Stack;

public class CheckGivenArrayIsPreOrderRepresentation {
    public static void main(String[] args) {
        int[] pre1 = new int[]{40, 30, 35, 80, 100};
        CheckGivenArrayIsPreOrderRepresentation obj = new CheckGivenArrayIsPreOrderRepresentation();
        obj.canReprsentBST(pre1);
    }
    public static void canReprsentBST(int[] pre)
    {
        int n = pre.length;
        Stack<Integer> st = new Stack<>();
        int root = Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {
            if(pre[i]<root)
            {
                System.out.println(" not representing as BST");
                return;
            }
            while(!st.isEmpty() && st.peek()<pre[i])
            {
                root =st.pop();
            }
            st.push(pre[i]);
        }
        System.out.println(" Can be represented as BST");
        return;
    }
}
