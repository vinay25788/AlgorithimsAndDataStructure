package datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueUsingRecursion {

    Queue<Integer> queue = new LinkedList<>();
    public  void enqueue(int data)
    {
        queue.add(data);
    }
    public void rev()
    {
        if(queue.isEmpty())
            return;
        int x = queue.remove();
        rev();
        queue.add(x);
    }

    public static void main(String[] args) {
        ReverseQueueUsingRecursion que = new ReverseQueueUsingRecursion();
        que.enqueue(1);
        que.enqueue(2);
        que.enqueue(3);
        que.enqueue(4);
        que.rev();
        System.out.println(que.queue);

    }
}
