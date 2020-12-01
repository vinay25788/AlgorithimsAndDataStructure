package datastructure.array.sort;

import java.util.Arrays;

public class Sort0s1s2s {
    public static void main(String[] args) {

        int a[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        sort(a);

    }
    public static void sort(int[] a)
    {
        int lo=0,hi = a.length-1;
        int mid =0 , temp =0;

        while(mid<=hi)
        {
            switch(a[mid])
            {
                case 0:
                {
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                }
                break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = a[mid];
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--;
                    break;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
