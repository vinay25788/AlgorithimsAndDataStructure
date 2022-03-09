package datastructure.recursion;

import java.util.Stack;

public class SortStackUsingRecursion {

    Stack<Integer> st = new Stack<>();
    public void push(int n)
    {
        st.push(n);
    }

    public void sort()
    {
         sort(st);
    }
    public void sort(Stack<Integer> st)
    {
        if(st.isEmpty())
            return;
        int x = st.pop();
        sort(st);
        insert(st,x);
    }

    public void insert(Stack<Integer> st,int x)
    {
        if(st.isEmpty() || st.peek()<= x)
        {
            st.push(x);
            return;
        }
        int temp = st.pop();
        insert(st,x);
        st.push(temp);
    }

    public void printStack()
    {
        while(!st.isEmpty())
        {
            System.out.print(st.peek()+" ");
            st.pop();
        }
    }


    public static void main(String[] args) {
        SortStackUsingRecursion obj = new SortStackUsingRecursion();
        obj.push(4);
        obj.push(2);
        obj.push(1);
        obj.push(30);
        obj.push(10);

        obj.sort();
        obj.printStack();

    }
}
