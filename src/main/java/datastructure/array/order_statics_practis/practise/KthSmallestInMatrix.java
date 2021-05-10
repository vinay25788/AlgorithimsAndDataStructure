package datastructure.array.order_statics_practis.practise;

public class KthSmallestInMatrix {
    static class HeapNode {
        int val;
        int r, c;

        HeapNode(int val, int r, int c) {
            this.val = val;
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        int mat[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {25, 29, 37, 48},
                {32, 33, 39, 50}};
        int k = 3;
        System.out.println(kthSmallest(mat, 4, k));

    }

    public static int kthSmallest(int[][] mat,int n,int k) {
        HeapNode[] heapNodes = new HeapNode[n];


        for (int i = 0; i < n; i++) {
            heapNodes[i] = new HeapNode(mat[0][i],0,i);
        }

        HeapNode heapNode = new HeapNode(0,0,0);

        for(int i=0;i<k;i++)
        {
            heapNode = heapNodes[0];
            int nextVal= heapNode.r<n -1 ? mat[heapNode.r+1][heapNode.c]:Integer.MAX_VALUE;
            heapNodes[0] = new HeapNode(nextVal,heapNode.r+1, heapNode.c);
            minHeap(heapNodes,0,n);
        }

        return heapNode.val;
    }


    public static void minHeap(HeapNode[] heapNodes,int i,int n)
    {

        int l = 2 * i +1;
        int r = 2 * i +2;

        int min = i;
        if( l< n && heapNodes[l].val<heapNodes[i].val)
            min = l;
        if( r < n && heapNodes[r].val < heapNodes[min].val)
            min = r;
        if(min != i )
        {
            HeapNode heapNode = heapNodes[min];
            heapNodes[min] = heapNodes[i];
            heapNodes[i] = heapNode;
            minHeap(heapNodes,min,n);

        }

    }
}