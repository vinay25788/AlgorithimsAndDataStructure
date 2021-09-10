package practice.datastructure.array.rotation;

import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6};
        int k = 2;
        rotate(a,k);
        System.out.println(Arrays.toString(a));
    }
    public static void rotate(int[] a,int k)
    {
        leftRotate(a,0,k-1);
        leftRotate(a,k,a.length-1);
        leftRotate(a,0,a.length-1);
    }
    public static void leftRotate(int[] a,int l,int h)
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
