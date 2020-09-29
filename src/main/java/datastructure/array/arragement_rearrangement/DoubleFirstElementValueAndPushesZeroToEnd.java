package datastructure.array.arragement_rearrangement;

import java.util.Arrays;

public class DoubleFirstElementValueAndPushesZeroToEnd {
    public static void main(String[] args) {
        int[] a ={2,2,0,0,4,4,8};
        doubleTheValueAndPushZero(a);
        System.out.println(Arrays.toString(a));
    }
    public static void doubleTheValueAndPushZero(int[] a)
    {
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            if(a[i] !=0 && a[i] == a[i+1])
            {
                a[i] = 2*a[i];
                a[i+1] =0;
                i++;
            }
        }
        pushesZeroAtEnd(a);
    }
    public static void pushesZeroAtEnd(int[] a)
    {
        int count =0;
        int n= a.length;
        for(int i=0;i<n;i++)
        {
            if(a[i] != 0)
                a[count++] = a[i];
        }
        while(count < n)
            a[count++] =0;
    }
}
