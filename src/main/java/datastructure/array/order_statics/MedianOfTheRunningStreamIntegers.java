package datastructure.array.order_statics;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfTheRunningStreamIntegers {
    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;

    MedianOfTheRunningStreamIntegers()
    {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public  double addNum(int num)
    {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if(minHeap.size()>maxHeap.size())
        {
            maxHeap.offer(minHeap.poll());
        }
        if(minHeap.size()>maxHeap.size())
            return minHeap.peek();
        else
            return (minHeap.size()>0 ?minHeap.peek():0+maxHeap.size()>0?maxHeap.peek():0)/2.0;
    }

    /*public double findMedian()
    {
        if(minHeap.size()>maxHeap.size())
            return minHeap.peek();
        else
            return (minHeap.peek()+maxHeap.peek())/2.0;
    }*/
    public static void main(String[] args) {
        int[] a= new int[]{5, 15, 10, 20, 3};
        MedianOfTheRunningStreamIntegers  obj = new MedianOfTheRunningStreamIntegers();
        int n = a.length;

        for(int i=0;i<n;i++)
        {
            System.out.println(obj.addNum(a[i]));
        }


    }
}
