package practice.datastructure.array.rotation;

import java.util.Arrays;

public class RightRotation {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int k = 2;
        rotate(a,k);
        System.out.println(Arrays.toString(a));
    }
    public static void rotate(int[] a,int k)
    {
        rightRotate(a,0,a.length-1);
        rightRotate(a,k,a.length-1);
        rightRotate(a,0,k-1);

    }
    public static void rightRotate(int[] a,int l,int h)
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
