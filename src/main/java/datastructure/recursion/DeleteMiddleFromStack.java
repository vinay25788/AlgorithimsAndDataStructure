package datastructure.recursion;

import java.util.Stack;

public class DeleteMiddleFromStack {
    Stack<Integer> st = new Stack<>();
    int size =0;
    public void push(int n)
    {
        st.push(n);
        size++;
    }

    public void deleteMiddle()
    {
        System.out.println(size);
        deleteMiddle(st,size/2);
    }
    public void deleteMiddle(Stack<Integer> st,int k)
    {
        if(k == 0)
        {
            st.pop();
            return;
        }
        int x = st.pop();
        deleteMiddle(st,k-1);
        st.push(x);
    }

    public void print()
    {
        while(!st.isEmpty())
        {
            System.out.print(st.pop()+" ");
        }
    }

    public static void main(String[] args) {
        DeleteMiddleFromStack obj = new DeleteMiddleFromStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.deleteMiddle();
        obj.print();
    }
}
