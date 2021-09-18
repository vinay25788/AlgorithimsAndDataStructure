package practice.stack;

import java.util.Stack;

public class NGE {
    static Stack<Integer> st = new Stack<>();

    private static void nextGE(int[] a)
    {
        st.push(a[0]);
        int n = a.length;
        for(int i=1;i<n;i++)
        {
            int x = a[i];
            while(!st.isEmpty() && a[i]>st.peek())
            {
                System.out.println(st.peek()+" "+x);
                st.pop();
            }
            st.push(x);
        }

        while(!st.isEmpty())
        {
            System.out.print(st.pop()+" -1");
            System.out.println();
        }

    }

    public static void main(String[] args) {
 int[] a ={11,13,21,3};
        nextGE(a);
    }
}
