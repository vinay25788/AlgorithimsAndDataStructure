package datastructure.stack;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    public  void enque(int data)
    {
        st1.push(data);
    }

    public int deque()
    {
        int x=-1;

        if(st1.isEmpty() && st2.isEmpty())
        {
            System.out.println(" Queue is empty ");
            System.exit(0);
        }

        if(st2.isEmpty())
        {
           while(!st1.isEmpty())
           {
               st2.push(st1.pop());
           }

           return st2.pop();
        }

        return st2.pop();
    }

    public static void main(String[] args) {
        QueueUsingStack obj = new QueueUsingStack();
        obj.enque(1);
        obj.enque(2);
        obj.enque(3);

        System.out.println(obj.deque());
        System.out.println(obj.deque());
        System.out.println(obj.deque());
    }
}
