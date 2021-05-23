package datastructure.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public void calculateSpan(int[] price,int n ,int [] s)
    {
        Stack<Integer> st = new Stack<>();
        s[0]=1;
        st.push(0);
        for(int i=1;i<n;i++)
        {
                while(!st.isEmpty() && price[st.peek()]<= price[i])
                    st.pop();
                s[i] = st.isEmpty()? i+1:i-st.peek();
                st.push(i);
        }
    }
    public static void main(String[] args) {
        int price[] = { 10, 4, 5, 90, 120, 80 };
        int n = price.length;
        int S[] = new int[n];
        StockSpanProblem obj = new StockSpanProblem();
        obj.calculateSpan(price,n,S);
        System.out.println(Arrays.toString(S));
    }
}
