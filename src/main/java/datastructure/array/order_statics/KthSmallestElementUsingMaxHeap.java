package datastructure.array.order_statics;

import java.util.Arrays;

public class KthSmallestElementUsingMaxHeap {
    public static void main(String[] args) {
        int[] a = {5, 2, 1, 3, 7, 8};
        int k = 2;
        findUsingMaxHeap(a, k);
    }

    public static void findUsingMaxHeap(int[] a, int k) {
        int n = a.length;
        if (k > n)
            return;

        for (int i = k - 1; i >= 0; i--)
            buildHeap(a, i, n);

        for(int i=n-1;i>=k;i--)
        {
            if(a[0] > a[i])
            {
                int temp = a[i];
                a[i] = a[0];
                a[0] = temp;
                buildHeap(a,0,i);
            }
        }
        System.out.println("sorted array ");
        System.out.println(Arrays.toString(a));
        System.out.println("kth smallest element ------->"+a[0]);
    }

    public static void buildHeap(int[] a, int i, int n) {
        int first = 2 * i + 1;
        int second = 2 * i + 2;
        int largest = i;
        if (first < n && a[first] > a[largest])
            largest = first;
        if (second < n && a[second] > a[largest])
            largest = second;
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            buildHeap(a,largest,n);
        }
    }
}
