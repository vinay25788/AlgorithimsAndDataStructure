package datastructure.array.order_statics.practice;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaxElement {
    public static void main(String[] args) {
        int a[] = {12, 1, 78, 90, 57, 89, 56};
        int k=3;
        findMax(a,k);
    }

    public static void findMax(int[] a,int k) {
        int n = a.length;
        Deque<Integer> qi = new LinkedList<>();
        for(int i=0;i<k;i++)
        {
            while(!qi.isEmpty() && a[i]>=a[qi.peekLast()])
                qi.removeLast();
            qi.addLast(i);
        }

        for(int i=k;i<n;i++)
        {
            System.out.print(" "+a[qi.peek()]);
            while(!qi.isEmpty() && qi.peek() <= i-k)
                qi.removeFirst();
            while(!qi.isEmpty() && a[i]>=a[qi.peekLast()])
                qi.removeLast();

            qi.addLast(i);
        }
        System.out.print(" "+a[qi.peek()]);
    }
}
