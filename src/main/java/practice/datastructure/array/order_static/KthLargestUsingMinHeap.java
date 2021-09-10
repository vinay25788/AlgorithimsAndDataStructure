package practice.datastructure.array.order_static;

public class KthLargestUsingMinHeap {
    public static void main(String[] args) {
        int[] a = {2, 10, 12, 8, 5, 19};
        int k = 4;
        kthSmallest(a, k);
    }

    public static void kthSmallest(int[] a, int k) {
        int n = a.length;
        for (int i = k - 1; i >= 0; i--)
            heapify(a, i, n);

        for(int i = n-1;i>=k;i--)
        {
            if(a[i]>a[0])
            {
                int temp = a[i];
                a[i] = a[0];
                a[0]  = temp;
                heapify(a,0,i);
            }
        }
        System.out.println(a[0]);
    }

    public static void heapify(int[] a, int i, int n) {
        int first = (2 * i) + 1;
        int second = (2 * i) + 2;
        int smallest = i;
        if(first <n && a[first]< a[i])
            smallest = first;
        if(second < n && a[second]< a[smallest])
            smallest = second;
        if(smallest != i)
        {
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
            heapify( a,smallest,n);
        }
    }
}
