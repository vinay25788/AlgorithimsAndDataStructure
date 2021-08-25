package datastructure.array.pracitise.array.rotation;

import java.util.Arrays;

public class RightRotate {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int d = 2;
        rightRotate(a,d);
        System.out.println(Arrays.toString(a));
    }
    public static void rightRotate(int[] a,int d)
    {
        reverse(a,0,a.length-1);
        reverse(a,d,a.length-1);
        reverse(a,0,d-1);
    }

    public static void reverse(int[] a,int l,int h)
    {
        int temp =0;
        while(l<=h)
        {
            temp = a[l];
            a[l ] = a[h];
            a[h] = temp;
            l++;
            h--;
        }
    }
}
