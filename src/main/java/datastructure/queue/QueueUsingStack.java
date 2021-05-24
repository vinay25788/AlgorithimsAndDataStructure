package datastructure.queue;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer>  st2 = new Stack<>();
    public static void main(String[] args) {


        QueueUsingStack obj = new QueueUsingStack();
        obj.enque(1);
        obj.enque(2);
        obj.enque(3);
        obj.enque(4);

        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());
    }

    public void enque(int x)
    {
        while(!st1.isEmpty())
            st2.push(st1.pop());
        st1.push(x);
        while(!st2.isEmpty())
            st1.push(st2.pop());
    }
    public int dequeue()
    {
        int x =-1;
        if(st1.isEmpty())
        {
            System.out.println(" queue is empty ");

        }
        else
        {
            x = st1.pop();
        }
        return x;

    }

}
