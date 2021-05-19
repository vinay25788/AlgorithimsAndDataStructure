package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class SegregateOddEven {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        segregate(a);
    }

    public static void segregate(int[] a) {
        int temp = 0;
        int i=-1, j = 0,n = a.length;
        while (j < n) {
            if(a[j] %2 ==0)
            {
                i++;
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
            j++;

        }
        System.out.println(Arrays.toString(a));
    }
}
