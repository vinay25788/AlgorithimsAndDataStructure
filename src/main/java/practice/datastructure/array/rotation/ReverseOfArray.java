package practice.datastructure.array.rotation;

import java.util.Arrays;

public class ReverseOfArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        reverse(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void reverse(int[] a,int l,int h)
    {
        int temp =0;
        while(l<h)
        {
            temp = a[l];
            a[l] = a[h];
            a[h] = temp;
            l++;
            h--;
        }
    }
}
