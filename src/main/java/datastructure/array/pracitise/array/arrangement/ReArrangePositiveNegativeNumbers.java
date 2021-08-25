package datastructure.array.pracitise.array.arrangement;

import java.util.Arrays;

public class ReArrangePositiveNegativeNumbers {
    public static void main(String[] args) {
        int[] a ={-1,-2,3,4,6,-7,-9};
        reArrange(a);
    }
    public static void reArrange(int[] a)
    {
        int i=-1,temp =0,n =a.length;
        for(int j=0;j<n;j++)
        {
            if(a[j] <0)
            {
                i++;
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }

        int pos = i+1;
        int neg = 0;
        while(pos<n && neg<pos && a[neg] <0)
        {
            temp = a[pos];
            a[pos] = a[neg];
            a[neg]   = temp;
            pos++;
            neg+=2;
        }

        System.out.println(Arrays.toString(a));

    }
}
