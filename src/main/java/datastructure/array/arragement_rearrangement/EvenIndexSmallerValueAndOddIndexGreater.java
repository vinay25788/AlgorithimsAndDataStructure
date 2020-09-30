package datastructure.array.arragement_rearrangement;

import java.util.Arrays;

public class EvenIndexSmallerValueAndOddIndexGreater {
    public static void main(String[] args) {
        int a[] = {4,3,2,6,7,8,9};
        reArrange(a);
        System.out.println(Arrays.toString(a));
    }
    public static void reArrange(int[] a)
    {
        int temp;
        int n = a.length;
        for(int i=0;i<n-2;i++)
        {
            if( i % 2 ==0 && a[i] > a[i+1])
            {
               swap(i,i+1,a);
            }
            if( i%2 != 0 && a[i]<a[i+1])
            {
                swap(i,i+1,a);
            }
        }
    }

    public static void swap( int current, int next,int[] a)
    {
        int temp;
        temp = a[current];
        a[current] = a[next];
        a[next] = temp;
    }
}
