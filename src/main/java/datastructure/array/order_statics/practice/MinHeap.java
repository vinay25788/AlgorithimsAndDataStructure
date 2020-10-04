package datastructure.array.order_statics.practice;

import java.util.Arrays;

public class MinHeap {
    public static void main(String[] args) {
        int[] a ={4,2,10,8,3};
        minHeap(a);
        System.out.println("****************************************************************");
        System.out.println(Arrays.toString(a));
    }
    public static void minHeap(int[] a)
    {
        int n = a.length;

        for(int i=(n/2);i>=0;i--)
            buildMinHeap(a,i,n);
        for(int i=n-1;i>=0;i--)
        {
                int temp = a[i];
                a[i] = a[0];
                a[0] = temp;
                buildMinHeap(a, 0, i);
        }
    }

    public static void buildMinHeap(int[] a,int i,int n)
    {
        int first = 2*i+1;
        int second = 2*i +2;
        int smallest = i;
        if(first<n && a[first] < a[smallest])
            smallest = first;
        if(second < n && a[second ] < a[smallest])
            smallest = second;
        if(smallest != i)
        {
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
            buildMinHeap(a,smallest,n);
        }
    }


}
