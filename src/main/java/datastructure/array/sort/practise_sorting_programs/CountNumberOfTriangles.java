package datastructure.array.sort.practise_sorting_programs;

import java.util.Arrays;

public class CountNumberOfTriangles {
    public static void main(String[] args) {
        int[] a = {4, 3, 5, 7, 6};
        countTriangle(a);
    }

    public static void countTriangle(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int l = 0, r = 0;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            l = 0;
            r = i - 1;
            while (l < r) {
                if (a[l] + a[r] > a[i])
                {
                    count += r - l;
                    r--;
                }
                else
                    l++;
            }
        }
        System.out.println(count);
    }
}
