package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class ReArrangePositiveNegative {
    public static void main(String[] args) {

        int [] a = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        reArrange(a);
        System.out.println("After reArrangement "+ Arrays.toString(a));

    }
    public static void reArrange(int[] a)
    {
        int temp=0;
        int i=-1,n = a.length;
        for(int j=0;j<n;j++)
        {
            if(a[j]<0)
            {
                i++;
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int pos = i+1, neg = 0;
        while(pos<n && neg<pos && a[neg]<0)
        {
            temp = a[neg];
            a[neg] = a[pos];
            a[pos] = temp;
            neg = neg+2;
            pos++;
        }
    }
}
