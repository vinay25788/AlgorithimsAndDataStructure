package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class RightGreaterElement {
    public static void main(String[] args) {
        int[] a = {16, 17, 4, 3, 5, 2};
        printRightGreater(a);
    }

    public static void printRightGreater(int[] a) {
        int n = a.length, max = a[n - 1];
        int curEle = max;
        a[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            int temp = a[i];
            a[i] = max;
            if (max < temp)
                max = temp;

        }
        System.out.println(Arrays.toString(a));
    }
}
