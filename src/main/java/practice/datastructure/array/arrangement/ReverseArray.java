package practice.datastructure.array.arrangement;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6};
        reverse(a);
    }
    public static void reverse(int[] a)
    {
        int l =0,h = a.length-1;
        while(l<h)
        {
            int temp = a[l];
            a[l] = a[h] ;
            a[h]     = temp;
            l++;
            h--;
        }
        System.out.println(Arrays.toString(a));
    }
}
