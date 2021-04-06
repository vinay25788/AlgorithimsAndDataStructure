package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        reverse(a);
        System.out.println(Arrays.toString(a));
    }
    public static void reverse(int[] a)
    {
        int temp;
        int l = 0;
        int h = a.length-1;
        while(l<h)
        {
            temp = a[l];
            a[l] = a[h];
            a[h] =temp;
            l++;
            h--;
        }
    }
}
