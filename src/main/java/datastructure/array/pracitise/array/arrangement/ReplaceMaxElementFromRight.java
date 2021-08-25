package datastructure.array.pracitise.array.arrangement;

import java.util.Arrays;

public class ReplaceMaxElementFromRight {
    public static void main(String[] args) {
        int a[] = {16, 17, 4, 3, 5, 2};
        replace(a);
        System.out.println(Arrays.toString(a));
    }
    public static void replace(int[] a)
    {
        int n = a.length;
        int maxSoFar = a[n-1];
        a[n-1] = -1;
        for(int i=n-2;i>=0;i--)
        {
            int temp = a[i];
            a[i] = maxSoFar;
            if(maxSoFar <temp)
                maxSoFar = temp;
        }
    }
}
