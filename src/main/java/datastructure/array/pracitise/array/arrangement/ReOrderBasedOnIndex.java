package datastructure.array.pracitise.array.arrangement;

import datastructure.array.optimize.MinimumDifferenceBetweenTwoNumbers;
import datastructure.array.searching_and_sorting.FindInSortedRotated;

import java.util.Arrays;

public class ReOrderBasedOnIndex {
    static int heapSize=0;
    public static void main(String[] args) {
        int a[] = { 50, 40, 70, 60, 90 };
        int index[] = { 3, 0, 4, 1, 2 };
        int n = a.length;

        heapSize = n;
        heapSort(a, index, n);
        System.out.println(Arrays.toString(a));
    }
    public static void heapSort(int[] a,int[] index,int size)
    {
        for(int i=size/2;i>=0;i--)
            heapify(a,index,i,size);

        for(int i=size-1;i>=0;i--)
        {
            int temp = index[0];
            index[0] = index[i];
            index[i] = temp;

            temp = a[0];
            a[0]= a[i];
            a[i] = temp;
            heapify(a,index,0,i);
        }
    }

    public static void heapify(int[] a,int[] index,int i,int size)
    {
     int first = 2*i+1;
     int second = 2 * i+2;

     int largest = i;
     if(first<size && index[first]>index[largest])
         largest = first;
     if(second<size && index[second ]> index[largest])
         largest = second;
     if(largest != i)
     {
         int temp = index[largest];
         index[largest] = index[i];
         index[i] = temp;

         temp = a[largest];
         a[largest] = a[i];
         a[i] = temp;
         heapify(a,index,largest,size);
     }
    }
}
