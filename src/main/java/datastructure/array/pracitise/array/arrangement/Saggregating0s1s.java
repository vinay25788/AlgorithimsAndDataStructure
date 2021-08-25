package datastructure.array.pracitise.array.arrangement;

import java.util.Arrays;

public class Saggregating0s1s {
    public static void main(String[] args) {
        int[] a ={1,0,1,0,1,0,1,0};
        segregate(a);
        System.out.println(Arrays.toString(a));
    }
    public static void segregate(int[] a)
    {
        int i=0,j = a.length-1;
           while(true) {
               while (i < a.length && a[i] == 0)
                   i++;
               while(j>=0 && a[j] == 1)
                   j--;
               if(i<j)
               {
                   int temp = a[i];
                   a[i] = a[j];
                   a[j]  = temp;
                   i++;
                   j--;
               }
               else
                   break;
           }
    }
}
