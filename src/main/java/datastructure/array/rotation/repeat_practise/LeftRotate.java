package datastructure.array.rotation.repeat_practise;

import java.util.Arrays;

public class LeftRotate {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("before Rotation " + Arrays.toString(a));
        int d = 2;
        leftRotate(a,0,d-1);
        leftRotate(a,d,a.length-1);
        leftRotate(a,0,a.length-1);
        System.out.println("after rotation  "+Arrays.toString(a));
    }
    public static void leftRotate(int[] a,int l, int h)
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
