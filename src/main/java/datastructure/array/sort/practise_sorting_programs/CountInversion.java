package datastructure.array.sort.practise_sorting_programs;

import java.util.Arrays;

public class CountInversion {
    public static void main(String[] args) {
        int[] a = {1, 20, 6, 4, 5};
        System.out.println(" count "+countInversion(a, 0, a.length-1));
    }

    public static int countInversion(int[] a, int l, int h) {
        int count = 0;
        if (l < h) {
            int mid = (l + h) / 2;
            count += countInversion(a, l, mid);
            count += countInversion(a,mid+1,h);
            count += mergeAndCount(a,l,mid,h);
        }
        return count;
    }
    public static int mergeAndCount(int[] a,int l,int mid,int h)
    {
        int i=0,j=0,k=l;
        int[] left = Arrays.copyOfRange(a,l,mid+1);
        int[] right = Arrays.copyOfRange(a,mid+1,h+1);
        int swap=0;
        while(i<left.length&& j < right.length)
        {
            if(left[i]<=right[j])
            {
                a[k++] = left[i++];
            }
            else
            {

                a[k++] = right[j++];
                swap +=mid+1-(l+i);

            }
        }
        while(i<left.length)
            a[k++] = left[i++];
        while(j<right.length)
            a[k++] = right[j++];

        return swap;
    }
}
