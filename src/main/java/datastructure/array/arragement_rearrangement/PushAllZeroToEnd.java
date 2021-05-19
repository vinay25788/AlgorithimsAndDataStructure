package datastructure.array.arragement_rearrangement;

import java.util.Arrays;

public class PushAllZeroToEnd {
    public static void main(String[] args) {
        int[] a = {1,0,2,0,0,0,0,4,0,6,0};
        pushAllZeroInSingleTraversal(a);
        System.out.println(Arrays.toString(a));
    }

    public static void pushAllZeroInSingleTraversal(int[] a)
    {
        int count =0;
        int temp =0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i] !=0)
            {
                temp = a[i];
                a[i] = a[count];
                a[count] = temp;
                count++;
            }
        }

    }
    public static void pushAllZero(int[] a)
    {
        int count =0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]!=0)
            {
               a[count++] = a[i];
            }
        }
       while(count<a.length)
           a[count++] = 0;
    }
}
