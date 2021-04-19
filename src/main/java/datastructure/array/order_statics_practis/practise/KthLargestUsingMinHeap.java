package datastructure.array.order_statics_practis.practise;

public class KthLargestUsingMinHeap {
    public static void main(String[] args) {
        int[] a = {1, 4, 2, 6, 7, 10};
        int k = 2;
        kthLargestElement(a, k);
        System.out.println(a[0]);
    }

    public static void kthLargestElement(int[] a, int k) {
        int n = a.length;
        for (int i = 0; i < k; i++)
            minHeap(a, i, n);
        for (int i = k; i < n; i++) {
            if (a[i] > a[0]) {
                a[0] = a[i];
                minHeap(a, 0, n);
            }
        }

    }

    public static void minHeap(int[] a, int i, int n) {
        int first = 2 * i + 1;
        int second = 2 * i + 2;
        int smallest = i;
        if (first < n && a[first] < a[i])
            smallest = first;
        if (second < n && a[smallest] > a[second])
            smallest = second;
        if (i != smallest) {
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
            minHeap(a, smallest, n);
        }
    }
}
