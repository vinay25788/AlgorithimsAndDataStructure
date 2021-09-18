package practice.stack;


import java.util.Stack;

public class QueueUsingSingleStack {

    private static Stack<Integer> st = new Stack<>();

    private static void enque(int x)
    {
        st.push(x);
    }

    private static int  deque()
    {
        int res =0;
        if(st.isEmpty())
        {
            System.out.println(" empty ");
            System.exit(0);
        }
        if(st.size() == 1)
        {
            return st.pop();
        }
        else
        {
            int x = st.pop();
             res = deque();

            st.push(x);
            return res;

        }
    }

    public static void main(String[] args) {
        enque(1);
        enque(2);
        enque(3);
        enque(4);
        System.out.println(deque());
        System.out.println(deque());
        System.out.println(deque());
        System.out.println(deque());
        System.out.println(deque());
        System.out.println(deque());


    }
}
