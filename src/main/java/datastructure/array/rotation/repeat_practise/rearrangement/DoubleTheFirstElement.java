package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class DoubleTheFirstElement {
    public static void main(String[] args) {
        int[] a = {0, 2 ,2 ,2, 0, 6, 6, 0, 0, 8};
        reArrange(a);
        System.out.println(Arrays.toString(a));
    }
    public static void reArrange(int[] a)
    {
        int n = a.length;
        if( n ==1)
            return;

        for(int i=0;i<n-1;i++)
        {
            if(a[i] == a[i+1])
            {
                a[i] = 2*a[i];
                a[i+1] = 0;
            }

        }

        pushZeroToEnd(a);

    }
    public static void pushZeroToEnd(int[] a)
    {
        int count =0;
        int temp=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i] !=0)
            {
                temp = a[i];
                a[i] = a[count];
                a[count] = temp;
                count++;
            }
        }
    }
}
