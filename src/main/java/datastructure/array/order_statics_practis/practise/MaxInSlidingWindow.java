package datastructure.array.order_statics_practis.practise;

import java.util.Deque;
import java.util.LinkedList;

public class MaxInSlidingWindow {
    public static void main(String[] args) {
        int[] a = {12, 1, 78, 90, 57, 89, 56};
        int k =3;
        printMax(a,k);
    }
    public static void printMax(int[] a,int k)
    {
        Deque<Integer> deque = new LinkedList<Integer>();

        for(int i=0;i<k;i++)
        {
            while(!deque.isEmpty() && a[i]> a[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);
        }

        int n = a.length;
        for(int i =k;i<n;i++)
        {
            System.out.print(" "+a[deque.peek()]+" ");

            while(!deque.isEmpty() && deque.peek() <= i-k)
                deque.removeFirst();

            while( !deque.isEmpty() && a[i]>= a[deque.peekLast()])
                deque.removeLast();

            deque.addLast(i);
        }
        System.out.print( " "+a[deque.peek()]);

    }
}
