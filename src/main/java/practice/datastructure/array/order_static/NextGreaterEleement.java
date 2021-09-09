package practice.datastructure.array.order_static;

import java.util.Stack;

public class NextGreaterEleement {
    public static void main(String[] args) {

         int arr[] = { 11, 13, 21, 3 };
         nextGreater(arr);


    }
    public static void nextGreater(int[] a)
    {
        Stack<Integer> st = new Stack<>();
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            int nxt = a[i];
            if(!st.isEmpty())
            {
                while(!st.isEmpty() && st.peek()<=nxt)
                    System.out.println(st.pop()+" "+nxt);
            }
            st.push(nxt);
        }
        while(!st.isEmpty())
            System.out.println(st.pop()+" -1 ");
    }
}
