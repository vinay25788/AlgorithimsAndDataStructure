package datastructure.array.order_statics_practis.practise;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfRunningArray {
    public static void main(String[] args) {
        int[] a = {5, 10, 15, 20};
        findMedian(a);
    }

    public static void findMedian(int[] a) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        double median = a[0];
        int n = a.length;
        maxHeap.add(a[0]);
        for (int i = 1; i < n; i++) {
            int el = a[i];
            if (maxHeap.size() > minHeap.size()) {
                if (el < median) {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(el);
                } else
                    minHeap.add(el);
                median = (double) (maxHeap.peek() + minHeap.peek()) / 2;
            } else if (maxHeap.size() == minHeap.size()) {
                if (el < median) {
                    maxHeap.add(el);
                    median = maxHeap.peek();
                } else {
                    minHeap.add(el);
                    median = minHeap.peek();
                }

            } else {
                if (el > median) {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(el);
                } else
                    maxHeap.add(el);
                median = (maxHeap.peek() + minHeap.peek()) / 2;
            }
            System.out.print(" " + median);
        }


    }

}
