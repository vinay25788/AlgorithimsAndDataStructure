package datastructure.array.pracitise.array.rotation;

import java.util.Arrays;

public class LeftRotation {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6};
        leftRotate(a,2);
        System.out.println(Arrays.toString(a));
    }

    public static void leftRotate(int[] a,int d)
    {
        reverse(a,0,d-1);
        reverse(a,d,a.length-1);
        reverse(a,0,a.length-1);
    }

    public static void reverse(int[] a,int l,int h)
    {
        int temp =0;
        while(l<=h)
        {
            temp = a[l];
            a[l] = a[h];
            a[h] = temp;
            l++;
            h--;
        }
    }

}
