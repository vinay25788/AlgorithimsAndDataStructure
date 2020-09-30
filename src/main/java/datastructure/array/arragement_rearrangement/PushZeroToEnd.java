package datastructure.array.arragement_rearrangement;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PushZeroToEnd {
    public static void main(String[] args) {
        int a[] = {1, 2, 0, 0, 5, 0, 6, 9, 0};
        //pushZeroToEnd(a);
        //System.out.println(Arrays.toString(a));
        pushZeroToEndUsingSingleTraversal(a);
        System.out.println(Arrays.toString(a));
    }

    public static void pushZeroToEndUsingSingleTraversal(int[] a)
    {
        int temp;
        int count =0;
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            if(a[i] !=0)
            {
                temp = a[count];
                a[count++] = a[i];
                a[i] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void pushZeroToEnd(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != 0)
                a[count++] = a[i];
        }

        while (count < n)
            a[count++] = 0;
    }

}
