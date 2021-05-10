package datastructure.array.order_statics_practis.practise;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    public static void main(String[] args) {
        int k = 3;
        int[] a = {12, 1, 78, 90, 57, 89, 56};
        printMax(a, k);
    }

    public static void printMax(int[] a, int k) {
        Deque<Integer> dque = new LinkedList<Integer>();
        int i = 0;
        for (i = 0; i < k; i++) {
            while (!dque.isEmpty() && a[i] > a[dque.peekLast()])
                dque.removeLast();
            dque.addLast(i);
        }

        int n = a.length;
        for (i = k; i < n; i++) {
            System.out.print(" " + a[dque.peek()] + " ");
            while (!dque.isEmpty() && dque.peek() <= i - k)
                dque.removeFirst();
            while (!dque.isEmpty() && a[i] >= a[dque.peekLast()])
                dque.removeLast();
            dque.addLast(i);

        }
        System.out.print(" " + a[dque.peek()]);
    }
}
