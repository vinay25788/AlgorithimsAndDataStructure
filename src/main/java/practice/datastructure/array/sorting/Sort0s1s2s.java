package practice.datastructure.array.sorting;

import java.util.Arrays;

public class Sort0s1s2s {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 1, 0, 0, 2, 0, 1, 2, 0,2,1};
        sort(a);
    }

    public static void sort(int[] a) {
        int n = a.length, left = 0, right = n - 1;

        for (int i = 0; i <= right; ) {
            if (a[i] == 0) {
                int temp = a[i];
                a[i] = a[left];
                a[left] = temp;
                i++;
                left++;
            } else if (a[i] == 2) {
                int temp = a[i];
                a[i] = a[right];
                a[right] = temp;
                right--;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
