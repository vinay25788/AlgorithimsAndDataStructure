package practice.datastructure.array.order_static;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {
    public static void main(String[] args) {

        int[] arr = new int[]{5, 15, 10, 20, 3};
        calculate(arr);
    }
    public static void calculate(int[] a)
    {
        double median = a[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder()); //smaller
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // greater
        maxHeap.add(a[0]);
        System.out.println(median+" ");
        int n = a.length;
        for(int i=1;i<n;i++)
        {
            if(maxHeap.size()>minHeap.size())
            {
                if(a[i]<median)
                {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(a[i]);
                }
                else
                {
                    minHeap.add(a[i]);
                }
                median = (maxHeap.peek()+ minHeap.peek())/2.0;
            }
            else if ( maxHeap.size() == minHeap.size())
            {
                if(a[i]<median)
                {
                    maxHeap.add(a[i]);
                    median = maxHeap.peek();
                }
                else
                {
                    minHeap.add(a[i]);
                    median = minHeap.peek();
                }
            }
            else
            {
                if(a[i]>median)
                {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(a[i]);
                }
                else
                    maxHeap.add(a[i]);
                median= (maxHeap.peek()+ minHeap.peek())/2.0;
            }
            System.out.println(median+" ");
        }
    }
}
