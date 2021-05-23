package datastructure.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int size;

    public void push(int data) {
        q1.add(data);
        size++;
    }

    public int getTop() {
        if (q1.isEmpty())
            return -1;
        while (q1.size() != 1) {
            q2.add(q1.remove());
        }
        int x = q1.remove();
        q2.add(x);
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return x;
    }

    public int pop() {
        if (q1.isEmpty())
            return -1;

        while (q1.size() != 1) {
            q2.add(q1.remove());
        }
        int x = q1.remove();
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return x;
    }

    public static void main(String... args) {
        ImplementStackUsingQueue obj = new ImplementStackUsingQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.getTop());
        System.out.println(obj.pop());
        System.out.println(obj.getTop());
        System.out.println(obj.pop());
    }
}
