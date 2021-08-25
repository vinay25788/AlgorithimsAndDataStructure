package datastructure.array.pracitise.array.orderstatics;

import java.util.Arrays;

public class KthSmallestUsingMaxHeap {


    class MinHeap {
        int[] hr;
        int heapSize;
        int capacity;

        MinHeap(int[] a, int heapSize, int capacity) {
            this.hr = a;
            this.heapSize = heapSize;
            this.capacity = capacity;

            int i = (heapSize - 1) / 2;
            while (i >= 0) {
                heapify(i);
                i--;
            }
        }

        public void heapify(int i) {
            int first = (2 * i) + 1;
            int second = (2 * i) + 2;
            int largest = i;
            if (first < heapSize && hr[first] > hr[i])
                largest = first;
            if (second < heapSize && hr[second] > hr[largest])
                largest = second;
            if (largest != i) {
                int temp = hr[largest];
                hr[largest] = hr[i];
                hr[i] = temp;
                heapify(largest);
            }
        }

        public int extractMax() {
            if (heapSize == 0)
                return Integer.MAX_VALUE;

            int root = hr[0];
            if (heapSize > 1) {
                hr[0] = hr[heapSize - 1];
                heapify(0);
            }
            heapSize--;
            return root;

        }

        public void replaceMax(int x)
        {
            hr[0] = x;
            heapify(0);
        }

        public int getMax()
        {
            return hr[0];
        }


    }

    public void kthSmallest(int[] a, int n, int k) {
        MinHeap mh = new MinHeap(a, k, n);

        for (int i = k; i < n; i++)
            if (a[i] < mh.getMax())
                mh.replaceMax(a[i]);
        System.out.println(Arrays.toString(mh.hr));
        System.out.println(mh.hr[0]);

    }

    public static void main(String[] args) {
        int[] a = {2, 10, 4, 14, 9, 11};
        KthSmallestUsingMaxHeap obj = new KthSmallestUsingMaxHeap();
        obj.kthSmallest(a, a.length, 4);
    }
}
