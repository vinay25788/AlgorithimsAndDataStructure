package datastructure.array.pracitise.array.orderstatics;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaxElement {
    public static void main(String[] args) {
        int[] a= { 12, 1, 78, 90, 57, 89, 56 };
        int k =3;
        slidingWindow(a,k);
    }
    public static void slidingWindow(int[] a,int k)
    {
        Deque<Integer> qi = new LinkedList<Integer>();
        int i=0;
        for( i=0;i<k;i++)
        {
            while(!qi.isEmpty() && a[i]>= a[qi.peekLast()])
                qi.removeLast();
            qi.addLast(i);
        }
        System.out.print(a[qi.peek()]+" ");
        qi.removeFirst();

        for(;i<a.length;i++)
        {
            if(!qi.isEmpty())
            System.out.print(a[qi.peek()]+" ");
            while(!qi.isEmpty() && qi.peek()<= i-k)
                qi.removeFirst();
            while(!qi.isEmpty() && a[i]>= a[qi.peekLast()])
                qi.removeLast();
            qi.addLast(i);

        }
        System.out.print(a[qi.peek()]+" ");
    }
}
