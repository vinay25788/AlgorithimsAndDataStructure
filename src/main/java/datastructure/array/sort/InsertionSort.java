package datastructure.array.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a={5,3,2,7,9,1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void sort(int[] a)
    {
        int n = a.length;
        for(int i=1;i<n;i++)
        {
            int key = a[i];
            int j = i-1;
            while(j>=0 && a[j]>key)
            {
                a[j+1] = a[j];
                j = j-1;
            }
            a[j+1] = key;
        }
    }
}
