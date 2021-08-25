package datastructure.array.pracitise.array.orderstatics;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfTheStream {
    public static void main(String[] args) {
        int[] a = new int[]{5, 15, 10, 20, 3};
        printMedian(a);
    }
    public static void printMedian(int[] a)
    {
        double median= a[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        maxHeap.add(a[0]);

        System.out.print(median+" ");
        int n = a.length;
        for(int i=1;i<n;i++)
        {
            int x = a[i];

            if(maxHeap.size()>minHeap.size())
            {
                if(x<median)
                {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(x);
                }
                else
                    minHeap.add(x);
                median = (double)   (maxHeap.peek()+minHeap.peek())/2.0;

            }
            else if ( maxHeap.size() == minHeap.size())
            {
                if(x<median)
                {
                    maxHeap.add(x);
                    median = maxHeap.peek();
                }
                else
                {
                    minHeap.add(x);
                    median = minHeap.peek();
                }
            }
            else
            {
                if(x>median)
                {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(x);
                }
                else
                {
                    maxHeap.add(x);
                }
                median = (maxHeap.peek()+minHeap.peek())/2.0;
            }
            System.out.println(median+" ");

        }
    }
}
