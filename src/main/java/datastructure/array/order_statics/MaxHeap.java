package datastructure.array.order_statics;

import java.util.Arrays;

public class MaxHeap {
    public static void main(String[] args) {
        int a[] ={4,3,2,15,6};
        maxHeap(a);
        System.out.println(Arrays.toString(a));
    }
    public static void maxHeap(int[] a)
    {
        int n = a.length;
        for(int i=(n-1)/2; i>=0;i--)
        {
            buildHeap(a,i,n);
        }

        for(int i=n-1;i>=0;i--)
        {
            if(a[0] > a[i])
            {
                int temp = a[i];
                a[i] = a[0];
                a[0] = temp;
                buildHeap(a,0,i);
            }
        }

    }

    public static void buildHeap(int[] a,int i,int n)
    {
        int first = 2*i +1;
        int second = 2*i +2;
        int largest = i;
        if(first< n && a[first] > a[largest])
            largest = first;
        if(second < n && a[second] > a[largest])
            largest = second;
        if(largest != i)
        {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            buildHeap(a,largest,n);
        }

    }
}
