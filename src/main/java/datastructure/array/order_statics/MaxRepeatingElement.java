package datastructure.array.order_statics;

import java.util.Arrays;

public class MaxRepeatingElement {
    public static void main(String[] args) {
        int[] a = {2, 3, 3, 5, 3, 4, 1, 7};
        findMaxRepeatingElement(a);
    }
    public static void findMaxRepeatingElement(int[] a)
    {
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            a[a[i]%8] +=8;
        }

        int max =a[0];
        int index=-1;
        System.out.println(Arrays.toString(a));
        for(int i=1;i<n;i++)
        {
            if(max<a[i])
            {
                max = a[i];
                index = i;
            }
        }
        System.out.println("max repeating element "+index);
    }
}
