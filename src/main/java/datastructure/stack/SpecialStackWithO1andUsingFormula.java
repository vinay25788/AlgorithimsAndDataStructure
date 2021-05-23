package datastructure.stack;

import java.util.Stack;

public class SpecialStackWithO1andUsingFormula {
    Stack<Integer> st = new Stack<>();
    int minEle;
    public void push(int data)
    {
        if(st.isEmpty())
        {
            st.push(data);
            minEle = data;
        }
        else
        {
            if(data>minEle)
            {
                st.push(minEle);
            }
            else
            {
                int x = 2*data-minEle;
                st.push(x);
                minEle=data;
            }
        }
    }

    public void peek()
    {
        if(st.isEmpty())
        {
            System.out.println(" stack is empty ");
            return;
        }
        Integer t = st.peek();
        System.out.println(" peek element is ");
        if(t<minEle)
            System.out.println(minEle);
        else
            System.out.println(t);
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
            if(x<minEle)
            {
                  int y = minEle;
                minEle =  2*minEle-x;
                return y;

            }
            else
                return x;
        }

    }

    public static void main(String[] args) {
        SpecialStackWithO1andUsingFormula obj = new SpecialStackWithO1andUsingFormula();
        obj.push(3);
        obj.push(5);
        obj.push(2);
        System.out.println(obj.pop());
        obj.peek();
        System.out.println("popped element "+obj.pop());
        obj.peek();
        System.out.println("popped element "+obj.pop());
        }
}
