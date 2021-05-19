package datastructure.array.arragement_rearrangement;

import java.util.Arrays;

public class ReplaceElementWithNextGreater {
    public static void main(String[] args) {
        int a[] = {16, 17, 4, 3, 5, 2};
        replaced(a);
        System.out.println(Arrays.toString(a));
    }
    public static void replaced(int[] a)
    {
        int n=a.length;
        int max_so_far = a[n-1];
        a[n-1] = -1;
        for(int i=n-2;i>=0;i--)
        {
            if(a[i]>max_so_far)
                max_so_far = a[i];
            a[i] = max_so_far;
        }
    }
}
