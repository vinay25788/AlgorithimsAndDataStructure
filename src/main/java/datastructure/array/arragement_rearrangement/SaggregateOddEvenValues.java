package datastructure.array.arragement_rearrangement;

import java.util.Arrays;

public class SaggregateOddEvenValues {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6,7,8};
        sagregate(a);
        System.out.println(Arrays.toString(a));
    }
    public static void sagregate(int[] a)
    {
        int i=-1, j=0;
        int n= a.length;
        int temp =0;
        while( j != n)
        {
            if(a[j] %2 ==0)
            {
                i++;
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            j++;
        }
    }
}
