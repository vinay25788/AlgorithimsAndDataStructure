package datastructure.array.order_statics;

import java.util.Stack;

public class NGE {
    public static void main(String[] args) {

        int a[] = {11, 13, 21, 3};
        findNGE(a);
    }

    public static void findNGE(int[] a) {
        Stack<Integer> st = new Stack<>();
        int next = -1;
        st.push(a[0]);
        int n = a.length;
        for (int i = 1; i < n; i++) {
            next = a[i];
            if (st.isEmpty() == false) {
                int el = st.pop();

                while (next > el) {
                    System.out.println(el + " ----" + next);
                    if (st.isEmpty())
                        break;
                    el = st.pop();
                }
                if (el > next)
                    st.push(el);
            }
            st.push(next);
        }
        while (!st.isEmpty()) {
            System.out.println(st.pop() + "----" + " -1");
        }
    }
}
