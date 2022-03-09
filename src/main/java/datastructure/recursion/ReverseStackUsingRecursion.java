package datastructure.recursion;


import java.util.Stack;

public class ReverseStackUsingRecursion {

    Stack<Integer> st = new Stack<>();
    public void push(int n)
    {
        st.push(n);
    }

    public void reverse()
    {
        reverse(st);
    }
    public void reverse(Stack<Integer> st)
    {
        if(st.isEmpty())
            return;
        int x = st.pop();
        reverse(st);
        insert(st,x);
    }
    public void insert(Stack<Integer> st,int x)
    {
        if(st.isEmpty())
        {
            st.push(x);
            return;
        }
        int temp = st.pop();
        insert(st,x);
        st.push(temp);
    }

    public void print()
    {
        while(!st.isEmpty())
        {
            System.out.print(st.pop()+" ");
        }
    }
    public static void main(String[] args) {
        ReverseStackUsingRecursion obj = new ReverseStackUsingRecursion();
        obj.push(10);
        obj.push(4);
        obj.push(3);
        obj.push(1);
        obj.reverse();
        obj.print();
    }
}
