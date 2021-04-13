package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class Segraget0sAnd1s {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0};
        segragate(a);
    }

    public static void segragate(int[] a) {
        int left = 0, right = a.length - 1;
        int n = a.length;
        int temp = 0;
        while (left < right) {
            while (left < right && a[left] == 0)
                left++;
            while (right > left && a[right] == 1)
                right--;
            if (left != right) {
                temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
