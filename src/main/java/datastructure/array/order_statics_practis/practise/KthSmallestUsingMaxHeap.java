package datastructure.array.order_statics_practis.practise;// A Java program to find k'th smallest element using max heap

public class KthSmallestUsingMaxHeap {
    public static void main(String[] args) {
        int[] a = {5, 3, 1, 8, 6};
        int k = 4;
        findKthSmallest(a, k);
        System.out.println(a[0]);
    }

    public static void findKthSmallest(int[] a, int k) {
        int n = a.length;
        for (int i = k / 2; i >= 0; i--) {
            maxHeap(a, i, n);
        }

        for (int i = k; i < n; i++) {

            if (a[i] < a[0]) {
                a[0] = a[i];
                maxHeap(a, 0, k);
            }
        }
    }

    public static void maxHeap(int[] a, int i, int n) {
        int first = 2 * i + 1;
        int second = 2 * 2 + 2;
        int largest = i;
        if (first < n && a[first] > a[i])
            largest = first;
        if (second < n && a[second] > a[largest])
            largest = second;
        if (i != largest) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            maxHeap(a, largest, n);
        }
    }

}


