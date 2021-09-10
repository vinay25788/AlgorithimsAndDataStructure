package practice.datastructure.array.sorting;

import java.util.Arrays;

public class AlternateSorting {

    public static void main(String[] args) {
        int[] a ={1,6,9,4,3,7,8,2};
        sort(a);
    }
    public static void sort(int[] a)
    {
       Arrays.sort(a);
       int i=0,n = a.length,j= n-1;

       while(i<j)
       {
           System.out.print(a[j--]+" "+a[i++]+" ");
       }
       if(n%2 !=0)
           System.out.println(a[i]);

    }
}
