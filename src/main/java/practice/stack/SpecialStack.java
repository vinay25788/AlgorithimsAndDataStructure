package practice.stack;

import java.util.Stack;

public class SpecialStack {
    static Stack<Integer> st = new Stack<>();
   static  int min =Integer.MAX_VALUE;

    private static void push ( int x)
    {
        if(st.isEmpty())
        {
            st.push(x);
            min = x;
        }
        else
        {
            if(x<min)
            {
                int el = 2*x - min;
                min = x;
                st.push(el);
            }
            else
            {
               st.push(x);
            }
        }
    }

    private static void pop()
    {
        if(st.isEmpty())
        {
            System.out.println("stack is empty");
            return;
        }
        else
        {
            int x = st.pop();
            if(x<min)
            {

                System.out.println("popeed element "+min);
                min = 2*min-x ;
            }
            else
                System.out.println("popeed element "+ x);
        }
    }
    private static int getMin()
    {
        return min;
    }
    public static void main(String[] args) {

        push(4);
        push(3);
        push(1);
        push(2);
        System.out.println("min element "+getMin());
      pop();
        System.out.println("minimum "+getMin());
        pop();
        System.out.println(" minimum "+getMin());

    }
}
