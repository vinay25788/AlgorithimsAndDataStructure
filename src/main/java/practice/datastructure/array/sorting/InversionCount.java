package practice.datastructure.array.sorting;

import java.util.Arrays;

public class InversionCount {
    public static void main(String[] args) {
        int[] a= { 1, 20, 6, 4, 5 };
        int l =0,r = a.length-1;
        System.out.println(mergeAndCount(a,l,r));
    }
    public static int mergeAndCount(int[] a,int l,int r)
    {
        int count =0;
        if(l<r)
        {
            int m = (l+r)/2;
            count += mergeAndCount(a,l,m);
            count += mergeAndCount(a,m+1,r);
            count += countInversion(a,l,m,r);
        }
        return count;
    }

    public static int countInversion(int[] a,int l,int m,int r)
    {
        int[] left = Arrays.copyOfRange(a,l,m+1);
        int[] right = Arrays.copyOfRange(a,m+1,r+1);
        int i=0,k=l,swap=0,j=0;

        while(i<left.length && j<right.length )
        {
            if(left[i]<=right[j])
            {
                a[k++] = left[i++];
            }
            else
            {
                a[k++] = right[j++];
                swap+= (m+1) - (l+i);
            }
        }

        while(i<left.length)
            a[k++] = left[i++];
        while(j<right.length)
            a[k++] = right[j++];
        return swap;
    }
}
