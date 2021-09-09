package practice.datastructure.array.order_static;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaximumOfAllElementInWindowK {
    public static void main(String[] args) {
        int a[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int k = 3;
        findMax(a, k);
        System.out.println();
        printMax(a, k);
    }

    public static void findMax(int[] a, int k) {
        int n = a.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(a[0]);
        for (int i = 0; i < k; i++) {
                pq.add(a[i]);
        }
        pq.remove(a[0]);
        for (int i = k; i < n; i++) {


                pq.add(a[i]);
            System.out.print(pq.peek() + " ");

            pq.remove(i - k + 1);
        }

    }
    static void printMax(int a[], int k)
    {
        int n = a.length;
        Deque<Integer> dq = new LinkedList<>();
        int i = 0;
        for(i=0;i<k;++i)
        {
            while(!dq.isEmpty() && a[dq.peekLast()]<=a[i])
                dq.removeLast();
            dq.addLast(i);
        }
        for(;i<n;++i)
        {
            System.out.print(a[dq.peek()]+" ");
            while(!dq.isEmpty() && dq.peek()<= i-k)
                dq.removeFirst();
            while(!dq.isEmpty() && a[dq.peekLast()]<= a[i])
                dq.removeLast();
            dq.addLast(i);
        }
        System.out.print(a[dq.peek()]+ " ");
    }


}
