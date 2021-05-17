package datastructure.array.sort.practise_sorting_programs;

import java.util.Arrays;

public class AlternateSorting {
    public static void main(String[] args) {
        int[] a ={1,5,2,40,34,20,30};
        alternateSorting(a);
    }
    public static void alternateSorting(int[] a)
    {
        Arrays.sort(a);
        int i=0,j=a.length-1;
        while(i<j)
        {
            System.out.print(" "+a[i++]+" "+a[j--]+" ");
        }
        if(a.length%2 !=0)
            System.out.print(a[j]);
    }
}
