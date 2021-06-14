package datastructure.heap;

public class KthSmallest {
    public static void main(String[] args) {
        int[] a = {4, 20, 15, 22, 50, 35};
        int k = 5;
        findKthSmallest(a, k);
    }

    public static void findKthSmallest(int[] a, int k) {
        int n = a.length;
        for (int i = k - 1; i >= 0; i--)
            heapify(a, i, n);
        for (int i = n-1; i >=k; i--) {
            if (a[i] < a[0]) {
                int temp = a[i];
                a[i] = a[0];
                a[0] = temp;
                heapify(a, 0, i);
            }
        }
        System.out.print(" " + a[0]);
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
