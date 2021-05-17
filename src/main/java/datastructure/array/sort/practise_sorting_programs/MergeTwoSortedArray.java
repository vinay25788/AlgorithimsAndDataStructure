package datastructure.array.sort.practise_sorting_programs;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {

        int[] a1 = {1, 3, 5, 7};

        int[] a2 = {0, 2, 6, 8, 9};

        merge(a1, a2);
    }

    public static void merge(int[] a1, int[] a2) {
        int n = a1.length;
        int m = a2.length;

        int firstElement = 0;
        int j=0;
        for(int i=0;i<n;i++)
        {
            if(a1[i]>a2[0])
            {
                int temp = a2[0];
                a2[0] = a1[i];
                a1[i] = temp;
                int k = 1;
                firstElement = a2[0];
                while(k<m && a2[k]<firstElement)
                {
                    a2[k-1] = a2[k];
                    k++;
                }
                a2[k-1] = firstElement;
            }
        }

        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));

    }

}
