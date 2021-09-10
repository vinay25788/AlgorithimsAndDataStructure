package practice.datastructure.array.arrangement;

import java.util.Arrays;

public class ReplaceElementFromRight {
    public static void main(String[] args) {
        int[] a = {16, 17, 4, 3, 5, 2};
        replace(a);
    }
    public static void replace(int[] a)
    {
        int n = a.length;
        int max = a[n-1];
         a[n-1] = -1;
        for(int i = n-2;i>=0;i--)
        {
            if(a[i]>max)
            {
                int temp = a[i];
                a[i] = max;
                max = temp;
            }
            else
                a[i] = max;
        }
        System.out.println(Arrays.toString(a));
    }
}
