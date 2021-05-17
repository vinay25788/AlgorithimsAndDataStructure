package datastructure.array.sort.practise_sorting_programs;

import java.util.Arrays;

public class PrintAllDistinctElement {
    public static void main(String[] args) {
        int[] a ={2,2,2,2,4,5,5,5,1,9,0};
        printDistinct(a);
    }
    public static void printDistinct(int[] a)
    {
        Arrays.sort(a);
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            while(i<n-1 && a[i]== a[i+1])
                i++;
            System.out.print(" "+a[i]);
        }
    }
}
