package datastructure.stack_practise;

import java.util.Stack;

public class MinStack {

    Stack<Integer> st = new Stack<>();
    int min=0;

    public void push(int n)
    {
        if(st.isEmpty())
        {
            st.push(n);
            min = n;
        }
        else
        {
            if(n>min)
                st.push(n);
            else
            {
                st.push(2*n-min);
                min = n;
            }
        }
    }

    public int pop()
    {
        if(st.isEmpty())
        {
            System.out.println("stack is empty");
            return -1;
        }
        else {
            int x = st.pop();
            if (x < min)
            {
                min = 2 * min - x;
                return min;
            }
            else
                return x;



        }
    }

    public void print()
    {
        while(!st.isEmpty())
            System.out.print(st.pop()+" ");
    }

    public int min()
    {
        return min;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(4);
        obj.push(5);
        obj.push(1);
        obj.push(7);
        obj.push(3);
        System.out.println("min "+obj.min());
        System.out.println("pop "+obj.pop());
        System.out.println("min "+obj.min());
        System.out.println("pop "+obj.pop());
        System.out.println("min "+obj.min());
    }
}
