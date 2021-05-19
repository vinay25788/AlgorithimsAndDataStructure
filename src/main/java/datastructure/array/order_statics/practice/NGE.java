package datastructure.array.order_statics.practice;

import java.util.LinkedList;
import java.util.Stack;

public class NGE {

    public static void main(String[] args) {
        int[] a={4,3,10,21,4,26};
        find(a);
    }
    public static void find(int[] a)
    {
        int n = a.length;
        Stack<Integer> st = new Stack<>();
        st.push(a[0]);
        int next,element;
        for(int i=1;i<n;i++)
        {
            next = a[i];
            if(!st.isEmpty())
            {
                element = st.pop();
                while(next>element)
                {
                    System.out.println(" element "+element+"  Greater   "+next);
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
        {
            System.out.println("element  "+st.pop()+ " Greater   -1");
        }
    }
}
