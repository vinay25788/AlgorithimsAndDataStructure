package datastructure.array.order_statics;// Java program to find med in
// stream of running integers

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfTheRunningStreamIntegers {

    // method to calculate med of stream
    public static void printMedian(int[] a) {

        double med = a[0];

        // max heap to store the minHeap half elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>
                (Collections.reverseOrder());

        // min-heap to store the maxHeap half elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        minHeap.add(a[0]);
        System.out.println(med);

        // reading elements of stream one by one
		/* At any time we try to make heaps balanced and
			their sizes differ by at-most 1. If heaps are
			balanced,then we declare median as average of
			min_heap_right.top() and max_heap_left.top()
			If heaps are unbalanced,then median is defined
			as the top element of heap of larger size */
        for (int i = 1; i < a.length; i++) {

            int x = a[i];

            // case1(left side heap has more elements)
            if (minHeap.size() > maxHeap.size()) {
                if (x < med) {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(x);
                } else
                    maxHeap.add(x);
                med = (double) (minHeap.peek() + maxHeap.peek()) / 2;
            }

            // case2(both heaps are balanced)
            else if (minHeap.size() == maxHeap.size()) {
                if (x < med) {
                    minHeap.add(x);
                    med = (double) minHeap.peek();
                } else {
                    maxHeap.add(x);
                    med = (double) maxHeap.peek();
                }
            }

            // case3(right side heap has more elements)
            else {
                if (x > med) {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(x);
                } else
                    minHeap.add(x);
                med = (double) (minHeap.peek() + maxHeap.peek()) / 2;

            }
            System.out.println(med);
        }
    }

    // Driver code
    public static void main(String[] args) {

        // stream of integers
        int[] arr = new int[]{5, 15, 10, 20, 3};
        printMedian(arr);
    }
}

// This code is contributed by Kaustav kumar Chanda.
