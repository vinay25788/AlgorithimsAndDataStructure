package datastructure.array.pracitise.array.orderstatics;

import java.util.Arrays;

public class SmallestKthElement {
    public static void main(String[] args) {
        int[] a = {1, 2, 5, 3, 10, 9};
        findKthSmallest(a, 2);
        findKthUsingMinHeap(a,2);
    }

    public static void findKthSmallest(int[] a, int k) {
        int n = a.length;
        for (int i = k/2; i >= 0; i--)
            heapify(a, i, n);

        for (int i = k; i < n; i++) {
            if (a[0] > a[i]) {
               a[0] = a[i];
                heapify(a, 0, k);
            }
        }

        System.out.println(Arrays.toString(a));
        System.out.println(a[0]);

    }


    public static void findKthUsingMinHeap(int[] a,int k)
    {
        int n = a.length;
        for (int i = k/2; i >= 0; i--)
            minHeapify(a, i, n);

        for (int i = k; i < n; i++) {
            if (a[0] > a[i]) {
                a[0] = a[i];
                minHeapify(a, 0, k);
            }
        }

        System.out.println(a[k]);
    }
    public static void minHeapify(int[] a, int i, int n) {
        int first = 2 * i + 1;
        int second = 2 * i + 2;
        int smallest = i;

        if (first < n && a[first] < a[i])
            smallest = first;
        if (second < n && a[second] < a[smallest])
            smallest = second;
        if (smallest != i) {
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
            minHeapify(a, smallest, n);
        }



    }

    public static void heapify(int[] a, int i, int n) {
        int first = 2 * i + 1;
        int second = 2 * i + 2;
        int largest = i;

        if (first < n && a[first] > a[i])
            largest = first;
        if (second < n && a[second] > a[largest])
            largest = second;
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, largest, n);
        }

    }
}
