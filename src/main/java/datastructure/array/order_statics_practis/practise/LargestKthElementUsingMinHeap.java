package datastructure.array.order_statics_practis.practise;

public class LargestKthElementUsingMinHeap {
    public static void main(String[] args) {
        int[] a = {3, 2, 5, 9, 8};
        int k = 3;
        largestKth(a, k);
        System.out.println(a[0]);
        for(int i=0;i<k;i++)
            System.out.print(a[i]+" ");
    }

    public static void largestKth(int[] a, int k) {
        int n = a.length;
        for (int i = k / 2; i >= 0; i--)
            minHeap(a, i, n);

        for (int i = k; i < n; i++) {
            if (a[i] > a[0]) {
                a[0] = a[i];
                minHeap(a, 0, k);
            }
        }
    }

    public static void minHeap(int[] a, int i, int n) {
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
            minHeap(a, smallest, n);
        }
    }
}
