package datastructure.array.rotation.repeat_practise.rearrangement;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReArrangeZeroToEnd {
    public static void main(String[] args) {
        int[] a= {1,0,3,0,4,0,5};
        pushZeroToEnd(a);
        System.out.println(Arrays.toString(a));
        int[] aa= {1,0,3,0,4,0,5};
        pushZeroToTheEnd(aa);
        System.out.println(Arrays.toString(aa));
    }

    public static void pushZeroToTheEnd(int[] aa)
    {
        int n = aa.length;
        int count =0,temp =0;
        for(int i=0;i<n;i++)
        {
            if(aa[i] != 0)
            {
                temp = aa[i];
                aa[i] = aa[count];
                aa[count] = temp;
                count++;
            }
        }
    }
    public static void pushZeroToEnd(int[] a)
    {
        int n = a.length;
        int count =0;
        for(int i=0;i<n;i++)
        {
            if(a[i] != 0)
                a[count++] = a[i];
        }
        while(count<n)
        {
            a[count++] =0;
        }
    }
}
