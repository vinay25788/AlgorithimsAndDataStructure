package datastructure.array.rotation.repeat_practise.rotation;

import java.util.Arrays;

public class RightRotate {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("Before Rotation " + Arrays.toString(a));
        int d = 2;
        rightRotate(a, a.length - d, a.length - 1);
        rightRotate(a, 0, a.length - 1 - d);
        rightRotate(a, 0, a.length - 1);
        System.out.println("After Rotation " + Arrays.toString(a));
    }

    public static void rightRotate(int[] a, int l, int h) {
        int temp;
        while (l < h) {
            temp = a[l];
            a[l] = a[h];
            a[h] = temp;
            l++;
            h--;
        }
    }

}
