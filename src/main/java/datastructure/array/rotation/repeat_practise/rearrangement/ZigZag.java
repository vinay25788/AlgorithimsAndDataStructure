package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class ZigZag {
    public static void main(String[] args) {
        int[] a = new int[] {4, 3, 7, 8, 6, 2, 1};
        zigZag(a);
    }
    public static void zigZag(int[] a)
    {
        Arrays.sort(a);
        int temp =0,n = a.length;
        for(int i=1;i<n ;)
        {
            temp = a[i];
            a[i] = a[i+1];
            a[i+1] = temp;
            i = i+2;
        }
        System.out.println(Arrays.toString(a));
    }
}
