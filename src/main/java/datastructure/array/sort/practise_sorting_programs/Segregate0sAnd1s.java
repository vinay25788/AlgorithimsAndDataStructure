package datastructure.array.sort.practise_sorting_programs;

import java.util.Arrays;

public class Segregate0sAnd1s {
    public static void main(String[] args) {
        int[] a = {1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0 };
        segregate(a);
    }
    public static void segregate(int[] a)
    {
        int i=0;
        int n = a.length;
        for(int j=0;j<n;j++)
        {
            if(a[j] ==0)
            {
                a[i] =0;
                i++;
                a[j] =1;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
