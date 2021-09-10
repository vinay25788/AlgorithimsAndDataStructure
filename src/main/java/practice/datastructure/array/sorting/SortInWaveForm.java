package practice.datastructure.array.sorting;

import java.util.Arrays;

public class SortInWaveForm {
    public static void main(String[] args) {
        int[] a = {10, 5, 6, 3, 2, 20, 100, 80};
        sortInWavForm(a);
    }

    public static void sortInWavForm(int[] a) {
        boolean flag= true;

        int n = a.length;
        for(int i=0;i<n-1;i++)
        {
            if(flag)
            {
                if(a[i]<a[i+1])
                {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
            else
            {
                if(a[i]>a[i+1])
                {
                    int temp =a [i];
                    a[i] = a[i+1]   ;
                    a[i+1]   = temp;
                }
            }
            flag = !flag;
        }
        System.out.println(Arrays.toString(a));
    }
}
