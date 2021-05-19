package datastructure.array.order_statics;

import java.util.Arrays;

public class FindKthSmallestElementUsingMinHeap {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 7, 22, 4, 5,};
        int k = 3;
        findKthUsingMinHeap(a, k);
    }

    public static void findKthUsingMinHeap(int[] a, int k) {
        int n = a.length;
        if (k > n)
            return;

        for (int i = k - 1; i >= 0; i--)
            buildHeap(a, i, n);

        for (int i = n - 1; i >= k; i--) {
            if (a[0] < a[i]) {
                int temp = a[i];
                a[i] = a[0];
                a[0] = temp;
                buildHeap(a, 0, i);
            }
        }

        System.out.println("array element ------------>");
        System.out.println(Arrays.toString(a));
        System.out.println(" kth smallest element --->" + a[0]);
    }

    public static void buildHeap(int[] a, int i, int n) {
        int first = 2 * i + 1;
        int second = 2 * i + 2;
        int smallest = i;
        if (first < n && a[first] < a[smallest])
            smallest = first;
        if (second < n && a[second] < a[smallest])
            smallest = second;
        if (smallest != i) {
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
            buildHeap(a, smallest, n);
        }
    }
}
