package datastructure.stack;

import java.util.Stack;

public class MinimumStack {

    Stack<Integer> st = new Stack<>();
    int min;

    public void push(int x)
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
                st.push(2*x - min);
                min =x;
            }
            else
                st.push(x);
        }
    }

    public int pop()
    {
        if(st.isEmpty())
        {
            System.out.println("stack is empty");
            return -1;
        }
        else
        {
            int x = st.pop();
            if(x> min)
            {
                return x;
            }
            else
            {
                int temp = min;
                min = 2 * min -x;
                return temp;
            }
        }

    }

    public int min()
    {
        return min;
    }

    public static void main(String[] args) {
        MinimumStack obj = new MinimumStack();
        obj.push(4);
        obj.push(5);
        obj.push(3);
        obj.push(8);
        obj.push(2);

        System.out.println("minimum "+obj.min());
        System.out.println("pop "+obj.pop());
        System.out.println("minimum "+obj.min());
        System.out.println("pop "+obj.pop());
        System.out.println("minimum "+obj.min());
        System.out.println("pop "+obj.pop());
        System.out.println("minimum "+obj.min());
        System.out.println("obj "+obj.pop());

    }

}
