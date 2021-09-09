package practice.datastructure.stack;

import java.util.Stack;

public class ReverseStackWithoutUsingExtraSpace {
    private static Stack<Integer> st = new Stack<>();
    public static void main(String[] args) {
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st);

        reverse();
        System.out.println("After reverse");
        System.out.println(st);
    }
    public static void reverse()
    {
        if(!st.isEmpty()){
        int x = st.pop();
        reverse();
        insertAtBottom(x);
        }
    }

    public static void insertAtBottom(int x)
    {
        if(st.isEmpty())
            st.push(x);
        else {
            int a = st.pop();
            insertAtBottom(x);
            st.push(a);
        }
    }

}
