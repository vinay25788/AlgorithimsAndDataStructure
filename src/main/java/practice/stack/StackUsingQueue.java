package practice.stack;



import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
  static  Queue<Integer> q1 = new LinkedList<>();
  static  Queue<Integer> q2 = new LinkedList<>();

    private static void push(int x)
    {
        q1.add(x);
    }

    private static void pop()
    {
        if(q1.isEmpty())
        {
            System.out.println(" empty ");
            return;
        }
        while(q1.size()>1)
        {
            q2.add(q1.remove());
        }
        System.out.println("popped element "+q1.remove());
        Queue<Integer> q ;
        q = q1;
        q1 = q2;
        q2 = q;

    }

    private static void top()
    {
        if(q1.isEmpty())
        {
            System.out.println(" empty ");
            return;
        }
        while(q1.size()>1)
        {
            q2.add(q1.remove());
        }
        System.out.println("top element "+q1.peek());
        q2.add(q1.remove());
        Queue<Integer> q ;
        q = q1;
        q1 = q2;
        q2 = q;


    }
    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);

      top();
      pop();
      top();
      pop();
      top();
      pop();
    }
}
