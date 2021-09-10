package practice.datastructure.array.searching;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int a[] = {1, 5, 9};
        int b[] = {2, 4, 7, 10};
        int n = a.length;
        int m = b.length;
        merge(a,n,b,m);
    }
    public static void merge(int[] a,int n,int[] b,int m)
    {
        int index = -1;

        int l=0;
        int r=0;
        int pivot =0;

        while(index<n && l<n && r<m)
        {
            if(a[l]<b[r])
                pivot = a[l++];
            else
                pivot = b[r++];
            index++;
        }

        while(index<n && l<n)
        {
            pivot = a[l++];
            index++;
        }
        while(index<n && r<m)
        {
            pivot = b[r++];
            index++;
        }
        partition(a,n,b,m,pivot);
        Arrays.sort(a);
        Arrays.sort(b);

        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
        for(int i=0;i<m;i++)
            System.out.print(b[i] +" ");
    }

    public static void partition(int[] a,int n,int[] b,int m,int pivot)
    {
        int l= n-1;
        int r =0;
        while(l>=0 && r<m)
        {
            if(a[l]<pivot)
                l--;
            else if ( b[r]>pivot)
                r++;
            else
            {
                int temp = a[l];
                a[l] = b[r];
                b[r] = temp;
                l--;
                r++;
            }
        }
    }
}
























