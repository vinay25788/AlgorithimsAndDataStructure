package datastructure.array.pracitise.array.arrangement;

import java.util.Arrays;

public class ReArrangePositiveNegative {
    public static void main(String[] args) {
        int[] a ={1,-2,3,4,-3,-10};
        reArrange(a);
        System.out.println(Arrays.toString(a));
    }
    public static void reArrange(int[] a)
    {
        int i=0,j = a.length-1;
        int n = a.length;
        while(true)
        {
            while(i<n && a[i]<0)
                i++;
            while(j>=0 && a[j]>0)
                j--;
            if(i<j)
            {
                int temp = a[i];
                a[i] = a[j] ;
                a[j]     = temp;

            }
            else
                break;
        }
    }
}
