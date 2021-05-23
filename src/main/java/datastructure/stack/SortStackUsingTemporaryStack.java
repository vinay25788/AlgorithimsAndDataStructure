package datastructure.stack;

import java.util.Stack;

public class SortStackUsingTemporaryStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(9);
        st.push(12);
        st.push(3);
        sortStack(st);
    }
    public static void sortStack(Stack<Integer> input)
    {
        Stack<Integer> tempStack= new Stack<>();
        while(!input.isEmpty())
        {
            int x = input.pop();
            while(!tempStack.isEmpty() && x<tempStack.peek())
                input.push(tempStack.pop());
            tempStack.push(x);
        }
        System.out.println(tempStack);
    }
}
