package datastructure.array.sort;

import java.util.Arrays;

public class AlternateSorting {
    public static void main(String[] args) {
        int[] a = new int[]{7, 1, 2, 3, 4, 5, 6};
        sort(a);
    }
    public static void sort(int[] a)
    {
        Arrays.sort(a);
        int i =0, j = a.length-1;
        while(i <=j)
        {
            if(i==j)
            {
                System.out.print(" "+a[i]);
                break;
            }
            System.out.print( " "+a[j--]);
            System.out.print( " "+a[i++]);
        }
    }
}
