package datastructure.stack;

import java.util.Stack;

public class SortStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(18);
        s.push(14);
        sortStack(s);
        System.out.println(s);
    }
    public static Stack sortStack(Stack<Integer>st)
    {
        if(!st.isEmpty())
        {
            int x = st.pop();
            sortStack(st);
            sortedStack(st,x);
        }
        return st;
    }
    public static void sortedStack(Stack<Integer> st,int x)
    {
        if(st.isEmpty() || x>st.peek())
            st.push(x);
        else
        {
            int a =st.pop();
            sortedStack(st,x);
            st.push(a);

        }
    }
}
