package datastructure.stack;

import java.util.Stack;

public class SpecialStackWithO1 {

    Stack<Node> st = new Stack<>();
    class Node
    {
        int val;
        int min;
        Node(int min,int val)
        {
            this.val = val;
            this.min = min;
        }
    }

    public void push(int data)
    {
        if(st.isEmpty())
            st.push(new Node(data,data));
        else
        {
            int min = Math.min(st.peek().min,data);
            st.push(new Node(min,data));
        }
    }

    public int pop()
    {
        if(st.isEmpty())
            return -1;
        return st.pop().val;
    }

    public static void main(String[] args) {
        SpecialStackWithO1 obj = new SpecialStackWithO1();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(" pop operation ");
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }
}
