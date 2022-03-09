package datastructure.binarysearch;

import java.util.Arrays;
import java.util.Stack;

public class LeftSmallerElement {
    public static void main(String[] args) {
        int[] a ={4,5,2,10,8};

        Stack<Integer> st = new Stack<>();

        int[] res = new int[a.length];

        for(int i=0;i<a.length;i++)
        {
            while(!st.isEmpty() && st.peek()>a[i])
                st.pop();
            if(st.isEmpty())
                res[i] = -1;
            else
                res[i] = st.peek();
            st.push(a[i]);
        }
        System.out.println(Arrays.toString(res));
    }
}
