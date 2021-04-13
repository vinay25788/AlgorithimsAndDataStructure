package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class ReArrangeMaximumMinimum {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        reArrange(a);
        System.out.println("After reArrangement " + Arrays.toString(a));
    }

    public static void reArrange(int[] a) {
        int n = a.length;
        int max_ele = a[n - 1] + 1, min_ele = a[0];
        int max_id = n - 1, min_id = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a[i] += (a[max_id] % max_ele) * max_ele;
                max_id --;
            } else {
                a[i] += (a[min_id] % max_ele) * max_ele;
                min_id++;
            }

        }
        System.out.println("after modification " + Arrays.toString(a));
        for (int i = 0; i < n; i++)
            a[i] = a[i] / max_ele;
    }
}
