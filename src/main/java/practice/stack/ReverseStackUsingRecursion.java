package practice.stack;

import java.util.Stack;

public class ReverseStackUsingRecursion {

    static Stack<Integer> st= new Stack<>();

    public static void main(String[] args) {
        st.push(1)  ;
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        for(int i=0;i<st.size();i++)
            System.out.print(st.get(i)+" ");

        reverse();
        System.out.println();
        for(int i=0;i<st.size();i++)
            System.out.print(st.get(i)+" ");
    }
    static void reverse()
    {
        if(st.isEmpty())
            return;
        else
        {
            int x = st.pop();
            reverse();
            insertinReveresed(x);
        }
    }

    private static void insertinReveresed(int x)
    {
        if(st.isEmpty())
            st.push(x);
        else
        {
            int rev = st.pop();
            insertinReveresed(x);
            st.push(rev);

        }
    }
}
