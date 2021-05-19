package datastructure.array.order_statics;

public class KthSmallestFromTwoDArray {

    public static class Node {
        int val;
        int r;
        int c;

        Node(int val, int r, int c) {
            this.val = val;
            this.r = r;
            this.c = c;
        }

    }

    public static void main(String[] args) {
        int a[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {25, 29, 37, 48},
                {32, 33, 39, 50}};
        findKth(a, 4, 7);

    }

    public static void findKth(int[][] a, int n, int k) {
        if (k > n && k > n * n)
            return;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(a[0][i], 0, i);
        }
        buildHeap(nodes, n);
        Node node = new Node(0, 0, 0);
        for (int i = 1; i < k; i++) {

            node = nodes[0];
            int nextVal = node.r < n - 1 ? a[node.r + 1][node.c] : Integer.MAX_VALUE;
            nodes[0] = new Node(nextVal, node.r + 1, node.c);
            minHeap(nodes, 0, n);
        }
        System.out.println("************");
        System.out.println(node.val);


    }

    public static void buildHeap(Node[] nodes, int n) {
        int i = (n - 1) / 2;
        while (i >= 0) {
            minHeap(nodes, i, n);
            i--;
        }
    }

    public static void minHeap(Node[] nodes, int i, int n) {
        int first = 2 * i + 1;
        int second = 2 * i + 2;
        int smallest = i;
        if (first < n && nodes[first].val < nodes[smallest].val)
            smallest = first;
        if (second < n && nodes[second].val < nodes[smallest].val)
            smallest = second;
        if (smallest != i) {
            Node temp = nodes[i];
            nodes[i] = nodes[smallest];
            nodes[smallest] = temp;
            minHeap(nodes, smallest, n);
        }
    }

}
