package datastructure.array.order_statics_practis.practise;

public class SmallestKthElementUsingMaxHeap {
    public static void main(String[] args) {
        int[] a = {2, 1, 3, 6, 7};
        int k = 3;
        kthSmallest(a, k);
        System.out.println(a[0]);
    }

    public static void kthSmallest(int[] a, int k) {
        int n = a.length;
        for (int i = k / 2; i >= 0; i--) {
            maxHeap(a, i, n);
        }
        for (int i = k; i < n; i++) {
            if (a[i] < a[0]) {
                int temp = a[i];
                a[i] = a[0];
                a[0] = temp;
                maxHeap(a, 0, k);
            }
        }
    }

    public static void maxHeap(int[] a, int i, int n) {
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
            maxHeap(a, largest, n);
        }


    }
}
