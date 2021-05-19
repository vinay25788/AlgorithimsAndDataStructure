package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class ReArrangeMaxmimumMinimum {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        reArrange(a);
        System.out.println(" After reArrangement " + Arrays.toString(a));
    }

    public static void reArrange(int[] a) {
        int[] temp = a.clone();
        int l = 0, h = a.length - 1;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = temp[h--];
            i++;
            if (i < n)
                a[i] = temp[l++];
        }
    }
}
