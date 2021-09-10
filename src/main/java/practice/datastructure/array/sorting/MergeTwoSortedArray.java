package practice.datastructure.array.sorting;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] a ={4,6,8,10};
        int[] b ={3,5,7,9};
        merge(a,b);
    }
    public static void mergek(int[] a,int[] b)
    {
        int n =a.length;
        int m = b.length;

        for(int i=m-1;i>=0;i--)
        {
            int j,last = a[n-1];
            for( j=n-1;j>=0 && a[j]>b[i];j--)
                a[j+1] = a[j]   ;

            if(j != n-2 && last>b[i])
            {
                a[j+1 ]= a[j];
                b[i] = last;
            }
        }
    }
    public static void merge(int[] a,int [] b)
    {
       int n = a.length;
       int m = b.length;
       for(int i=0;i<n;i++)
       {
           if(a[i]>b[0])
           {
               int temp = a[i];
               a[i] = b[0];
               b[0]  = temp;
           }
           int firstEle = b[0];
           int k =1;
           for(;k<m && b[k] < firstEle;k++)
           {

                   b[k-1] = b[k] ;
           }
           b[k-1] = firstEle;
       }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
