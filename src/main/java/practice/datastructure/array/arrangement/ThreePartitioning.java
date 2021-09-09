package practice.datastructure.array.arrangement;

import java.util.Arrays;

public class ThreePartitioning {
    public static void main(String[] args) {
        int [] a ={1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        partition(a,10,20);
    }
    public static void partition(int[] a,int l,int h)
    {
        int temp =0,n = a.length;
        int start =0, end = n-1;

        for(int i=0;i<=end;)
        {
            if(a[i]<l)
            {
                temp = a[i];
                a[i] = a[start];
                a[start] = temp;
                start++;
                i++;
            }
            else if ( a[i]> h)
            {
                temp = a[i];
                a[i] = a[end] ;
                a[end]   = temp;
                end--;
            }
            else
                i++;

        }
        System.out.println(Arrays.toString(a));

    }
}
