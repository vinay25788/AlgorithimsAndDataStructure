package practice.datastructure.array.order_static;

public class KthSmallestFromMatrix {

    static class HeapNode {
        int ele;
        int r, c;

        HeapNode(int ele, int r, int c) {
            this.ele = ele;
            this.r = r;
            this.c = c;
        }
    }

    static class MinHeap {
        static HeapNode[] har;
        static int heapSize;

        MinHeap(HeapNode[] har, int heapSize) {
            this.har = har;
            this.heapSize = heapSize;
        }

        public static void kthSmallest(int[][] mat, int n, int k) {
            har = new HeapNode[n];
            heapSize = k;
            for (int i = 0; i < n; i++) {
                har[i] = new HeapNode(mat[0][i], 0, i);
            }

            HeapNode hr = new HeapNode(0, 0, 0);
            for (int i = 1; i <= k; i++) {
                hr = har[0];
                int nextVal = hr.r < n - 1 ? mat[hr.r + 1][hr.c] : Integer.MAX_VALUE;
                har[0] = new HeapNode(nextVal, hr.r + 1, hr.c);
                heapify(har, 0, n);
            }
            System.out.println(hr.ele);
        }

        public static void heapify(HeapNode[] har, int i, int n) {
            int first = (2 * i) + 1;
            int second = (2 * i) + 2;
            int smallest = i;
            if (first < n && har[first].ele < har[i].ele && har[second].ele < har[i].ele)
            {
                HeapNode temp = har[i];
                har[i] = har[first];
                har[first] = temp;
                heapify(har, first, n);
               heapify(har,second,n);

            }
            if (second < n && har[second].ele < har[smallest].ele)
            {
                HeapNode temp = har[i];
                har[i] = har[second];
                har[second] = temp;
                heapify(har, second, n);

            }

        }

    }

    public static void main(String[] args) {
        int mat[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {25, 29, 37, 48},
                {32, 33, 39, 50}};

        MinHeap.kthSmallest(mat, 4, 10);
    }
}
