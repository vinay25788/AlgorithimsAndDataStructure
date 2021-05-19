package datastructure.array.sort.practise_sorting_programs;

import java.util.Arrays;

public class Sort0s1s2s {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 0, 1, 2, 1};
        sort(a);
    }

    public static void sort(int[] a) {
        int left=0,right = a.length-1;

        int n = a.length;
        int temp =0;
        int i=0;
        while(i<right)
        {
            if(a[i] == 0)
            {
                temp = a[i];
                a[i] = a[left];
                a[left] = temp;
                left++;
                i++;
            }
            else if( a[i] == 1)
            {
                i++;
            }
            else if ( a[i] == 2)
            {
                temp = a[i];
                a[i] = a[right];
                a[right] = temp;
                right--;

            }
        }
        System.out.println(Arrays.toString(a));
    }
}
