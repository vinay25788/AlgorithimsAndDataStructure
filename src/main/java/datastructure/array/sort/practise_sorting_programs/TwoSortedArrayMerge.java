package datastructure.array.sort.practise_sorting_programs;

import java.util.Arrays;

public class TwoSortedArrayMerge {
    public static void main(String[] args) {
        int[] a ={5,10,15,25};
        int[] b ={2,6,11,19};
        merge(a,b);
    }
    public static void merge(int[] a,int [] b)
    {
        int n = a.length;
        int m = b.length;
        int firstElement =0;
        for(int i=0;i<n;i++)
        {
            if(a[i] > b[0])
            {
                int temp = a[i];
                a[i] = b[0];
                b[0] = temp;
                firstElement = b[0];
                int j;
                for(j=1;j<m && b[j]<firstElement;j++)
                    b[j-1] = b[j];
                b[j-1] = firstElement;
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
