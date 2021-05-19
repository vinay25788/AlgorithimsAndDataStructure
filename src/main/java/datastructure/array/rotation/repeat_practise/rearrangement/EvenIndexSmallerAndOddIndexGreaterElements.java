package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class EvenIndexSmallerAndOddIndexGreaterElements {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 6, 7};
        reArrange(a);
        System.out.println(Arrays.toString(a));
    }

    public static void reArrange(int[] a) {
        int temp = 0, n = a.length;
        for (int i = 0; i < n-1; i++) {
            if(i %2 ==0 && a[i] > a[i+1])
            {
                temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
            if(i %2 !=0 && a[i] < a[i+1])
            {
                temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }
    }
}
