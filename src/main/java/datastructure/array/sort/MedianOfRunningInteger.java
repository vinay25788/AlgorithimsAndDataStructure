package datastructure.array.sort;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfRunningInteger {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    public static void main(String[] args) {
        int[] a ={5, 15, 10, 20, 3};
        printMedian(a);
    }
    public static void printMedian(int[] a)
    {
        double median = a[0];
        System.out.print(" "+median);
        PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> bigger = new PriorityQueue<>();

        smaller.add(a[0]);
        int n = a.length;
        for(int i=1;i<n;i++)
        {
            int x = a[i];
            if(smaller.size()>bigger.size())
            {
                if(x<median)
                {
                    bigger.add(smaller.remove());
                    smaller.add(x);
                }
                else
                    bigger.add(x);
                median = (smaller.peek()+bigger.peek())/2;
            }
            else if ( smaller.size() == bigger.size())
            {
                if(x<median)
                {
                    smaller.add(x);
                    median = (double)smaller.peek();
                }
                else
                {
                    bigger.add(x);
                    median = (double)bigger.peek();
                }
            }
            else
            {
                if(x>median)
                {
                    smaller.add(bigger.remove());
                    bigger.add(x);
                }
                else
                    smaller.add(x);
                median = (smaller.peek()+bigger.peek())/2;

            }
            System.out.print(" "+median);
        }

    }
}
