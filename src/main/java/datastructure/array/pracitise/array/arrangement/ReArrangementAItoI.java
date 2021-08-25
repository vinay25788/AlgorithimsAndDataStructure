package datastructure.array.pracitise.array.arrangement;

import java.util.Arrays;

/*
Rearrange an array such that arr[i] = i
Input : arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}
Output : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
 */
public class ReArrangementAItoI {
    public static void main(String[] args) {
        int[] a = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        reArrange(a);
    }

    public static void reArrange(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != -1 && a[i] != i) {
                int x = a[i];
                while (a[x] != -1 && a[x] != x) {
                    int y = a[x];
                    a[x] = x;
                    x = y;
                }
                a[x] = x;
                if (a[i] != i)
                    a[i] = i;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
