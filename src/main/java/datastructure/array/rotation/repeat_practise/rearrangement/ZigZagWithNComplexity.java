package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class ZigZagWithNComplexity {
    public static void main(String[] args) {
        int[] a = new int[]{4, 3, 7, 8, 6, 2, 1};
        zigZag(a);
        System.out.println(Arrays.toString(a));
    }

    public static void zigZag(int[] a) {
        int temp = 0, n = a.length;
        boolean flag = true;
        for (int i = 0; i < n-1; i++) {
            if(flag)
            {
                if(a[i]>a[i+1])
                {
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
            else
            {
                if( a[i] < a[i+1])
                {
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
            flag = !flag;
        }
    }
}
