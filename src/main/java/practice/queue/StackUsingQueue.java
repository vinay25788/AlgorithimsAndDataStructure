package practice.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private static Queue<Integer> que = new LinkedList<>();

    private static void push(int data)
    {
        int size = que.size();
        que.add(data);
        for(int i=0;i<size;i++)
            que.add(que.remove());
    }

    private static int pop()
    {
       return que.remove();
    }
    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        System.out.println();
        System.out.println("popped element "+pop());
        System.out.println("popped element "+pop());



    }
}
