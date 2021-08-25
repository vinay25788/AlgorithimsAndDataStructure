package datastructure.array.pracitise.array.arrangement;

import java.util.Arrays;

class MinHeapNode
{
    int root;
    int i,j;
    MinHeapNode(int root,int i,int j)
    {
        this.root = root;
        this.i = i;
        this.j = j;
    }
}
class MinHeap
{
    MinHeapNode[] harr;
    int heapSize =0;

    MinHeap()
    {

    }
    MinHeap(MinHeapNode[] harr,int size)
    {
        this.heapSize = size;
        this.harr = harr;
        int i = (heapSize-1)/2;
        while(i>=0)
        {
            heapify(i);
            i--;
        }
    }

    public  void heapify(int i)
    {
        int first = 2*i +1;
        int second = 2*i +2;
        int smaller = i;
        if(first<heapSize && harr[first].root < harr[i].root)
            smaller = first;
        if(second < heapSize && harr[second].root < harr[smaller].root)
            smaller = second;

        if(smaller != i)
        {
            MinHeapNode temp = harr[i];
            harr[i] = harr[smaller] ;
            harr[smaller] = temp;
            heapify(smaller);
        }
    }

    MinHeapNode getMin()
    {
        if(heapSize<=0)
        {
            System.out.println(" under flow ");
            return null;
        }
        return harr[0];
    }

    void replace(MinHeapNode root)
    {
        harr[0]  = root;
        heapify(0);
    }

    public void mergeKArray(int[][] arr,int k)
    {
        MinHeapNode[] hA = new MinHeapNode[k];
        int resultSize =0;

        for(int i=0;i<arr.length;i++)
        {
            MinHeapNode root= new MinHeapNode(arr[i][0],i,1);
            hA[i] = root;
            resultSize+= arr[i].length;

        }

        MinHeap mh = new MinHeap(hA,k);
        int[] result = new int[resultSize];

        for(int i=0;i<resultSize;i++)
        {
            MinHeapNode root = mh.getMin();
            result[i] = root.root;

            if(root.j<arr[root.i].length)
                root.root = arr[root.i][root.j++];
            else
                root.root = Integer.MAX_VALUE;

            mh.replace(root);
        }

        System.out.println(Arrays.toString(result));
    }
}
public class MergeSortedArray {
    public static void main(String[] args) {
        int[][] arr= {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};

        System.out.println("Merged array is :");
        MinHeap obj = new MinHeap();
        obj.mergeKArray(arr,arr.length);
    }


}
