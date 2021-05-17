package datastructure.array.sort.practise_sorting_programs;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfRunningInteger {
    public static void main(String[] args) {
        int[] a = {5, 15, 10, 20, 3};
        findMedian(a);
    }

    public static void findMedian(int[] a) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        double median;
        median = a[0];
        maxHeap.add(a[0]);
        System.out.println(median);
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int el = a[i];
            // smaller = maxHeap
            // Greater = minHeap
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
                    median = (double) maxHeap.peek();
                } else {
                    minHeap.add(el);
                    median = (double) minHeap.peek();
                }

            } else {
                // smaller = maxHeap
                // Greater = minHeap
                if (el > median) {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(el);
                } else
                    maxHeap.add(el);

                median = (double) (maxHeap.peek() + minHeap.peek()) / 2;
            }
            System.out.println(median);

        }
    }
}

