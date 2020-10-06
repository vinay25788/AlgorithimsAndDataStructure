package datastructure.array.order_statics.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MeadianOfStreamOfIntegers {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

    public static void findMedian(int[] a) {
        int n = a.length;
        double med = a[0];
        minHeap.add(a[0]);
        System.out.print(med + " ");
        for (int i = 1; i < n; i++) {
            int x = a[i];
            if (minHeap.size() > maxHeap.size()) {
                if (x < med) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(x);
                } else
                    maxHeap.add(x);
                med = (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else if (minHeap.size() == maxHeap.size()) {
                if (x < med) {
                    minHeap.add(x);
                    med = (double) minHeap.peek();
                } else {
                    maxHeap.add(x);
                    med = (double) maxHeap.peek();
                }
            } else {
                if (x > med) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(x);
                } else
                    minHeap.add(x);
                med = (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
            System.out.print(" " + med);
        }
    }

    public static void main(String[] args) {

        // stream of integers
        int[] a = new int[]{5, 15, 10, 20, 3};
        findMedian(a);
    }
}
