package datastructure.array.sort.practise_sorting_programs;

import java.util.Arrays;

public class SortingInWaveForm {
    public static void main(String[] args) {
        int[] a = {10, 5, 6, 3, 2, 20, 100, 80};
        sortInWaveForm(a);
    }
    public static void sortInWaveForm(int[] a)
    {
        int n = a.length;
        for(int i=0;i<n;i+=2)
        {
            if(i>0 && a[i] < a[i-1])
            {
                int temp = a[i];
                a[i] = a[i-1];
                a[i-1] = temp;
            }
            if( i<n-1 && a[i]< a[i+1])
            {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }

        }
        System.out.println(Arrays.toString(a));
    }
}
