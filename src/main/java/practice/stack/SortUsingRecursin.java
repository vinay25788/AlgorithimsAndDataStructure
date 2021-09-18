package practice.stack;

import java.util.Stack;

public class SortUsingRecursin {
    static Stack<Integer> st = new Stack<>();
    public static void main(String[] args) {
        st.push(5);
        st.push(2);
        st.push(4);
        st.push(3);
   st.push(400);
   st.push(200);
        sortUsingRecursion();
        for(int i=0;i<st.size();i++)
            System.out.print(st.get(i)+" ");
    }
    private static void sortUsingRecursion()
    {
        if(st.isEmpty())
        {
            return;
        }
        else
        {
            int x = st.pop();
            sortUsingRecursion();
            insertInSorted(x);
        }
    }
    private static void insertInSorted(int x)
    {
        if(st.isEmpty() || st.peek()<x)
        {
            st.push(x);
        }
        else
        {
            int res = st.pop();
            insertInSorted(x);
            st.push(res);
        }
    }
}
