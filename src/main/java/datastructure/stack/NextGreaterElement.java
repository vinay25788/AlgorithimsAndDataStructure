package datastructure.stack;

import java.util.Stack;

public class NextGreaterElement {
    public static void nextGreaterElement(int[] a) {
        Stack<Integer> st = new Stack<>();
        st.push(a[0]);
        int element, next;
        int n = a.length;
        for (int i = 1; i < n; i++) {
            next = a[i];
            if(!st.isEmpty())
            {
                element = st.pop();
                while( element < next)
                {
                    System.out.println(element +" "+next);
                    if(st.isEmpty())
                        break;
                    element = st.pop();
                }
                if(element>next)
                    st.push(element);
            }
            st.push(next);
        }

        while(!st.isEmpty())
            System.out.println(st.pop()+" -1");
    }

    public static void main(String[] args) {
        int a[] = {11, 13, 21, 3};
        nextGreaterElement(a);
    }
}
