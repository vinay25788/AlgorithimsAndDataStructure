package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

/*
Rearrange an array such that arr[i] = i
 */
public class ReArragment {
    public static void main(String[] args) {
        int[] a = new int[]{-1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
        System.out.println(Arrays.toString(fix(a)));
    }

    public static int[] fix(int[] a) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] != -1 && a[i] != i) {
                int x = a[i];
                while (a[x] != -1 && a[x] != x) {
                    int y = a[x];
                    a[x] = x;
                    x = y;
                }
                a[x] = x;
                if (a[i] != i) {
                    a[i] = -1;
                }
            }
        }
        return a;
    }
}
