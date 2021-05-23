package datastructure.stack;

import java.util.Stack;

public class ReverseStackUsingRecursion {

    public static Stack reverse(Stack<Integer> st)
    {
        if(!st.isEmpty())
        {
            int x = st.pop();

            reverse(st);

            insertAtBottom(st,x);

        }
        return st;
    }

    public static void insertAtBottom(Stack<Integer> st,int x)
    {
        if(st.isEmpty())
            st.push(x);
        else
        {
            int a = st.pop();
            insertAtBottom(st,x);
            st.push(a);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st);
        System.out.println(reverse(st));
    }
}
