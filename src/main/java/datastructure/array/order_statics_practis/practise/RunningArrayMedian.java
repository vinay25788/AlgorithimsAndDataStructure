package datastructure.array.order_statics_practis.practise;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningArrayMedian {
    public static void main(String[] args) {
        int[] a = {5, 15, 10, 20, 3};
        findMedian(a);
    }

    public static void findMedian(int[] a) {
        double median = a[0];
        System.out.print(median + " ");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        maxHeap.add(a[0]);
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int ele = a[i];
            if (maxHeap.size() > minHeap.size()) {
                if (ele < median) {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(ele);
                } else {
                    minHeap.add(ele);
                }
                median = (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else if (maxHeap.size() == minHeap.size()) {
                if (ele < median) {
                    minHeap.add(ele);
                    median = maxHeap.peek();
                } else {
                    maxHeap.add(ele);
                    median = maxHeap.peek();
                }
            } else {
                if (ele > median) {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(ele);
                } else
                    maxHeap.add(ele);

                median = (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
            System.out.print(" " + median);
        }
    }
}
