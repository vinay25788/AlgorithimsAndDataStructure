package datastructure.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfRunningInteger {

    public static void main(String[] args) {
        int[] a = {5, 10, 15, 20};
        findMedian(a);
    }

    public static void findMedian(int[] a) {
        int n = a.length;
        double median = a[0];
        System.out.print(median + " ");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        maxHeap.add(a[0]);
        for (int i = 1; i < n; i++) {
            int x = a[i];
            if (maxHeap.size() > minHeap.size()) {
                if (x < median) {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(x);
                } else
                    minHeap.add(x);
                median = (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else if (maxHeap.size() == minHeap.size()) {
                if (x < median) {
                    maxHeap.add(x);
                    median = maxHeap.peek();
                } else {
                    minHeap.add(x);
                    median = minHeap.peek();
                }
            } else {
                if (x > median) {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(x);
                }
                else
                {
                    maxHeap.add(x);
                }
                median = (maxHeap.peek()+minHeap.peek())/2.0;
            }
            System.out.print(median+" ");


        }
    }
}
