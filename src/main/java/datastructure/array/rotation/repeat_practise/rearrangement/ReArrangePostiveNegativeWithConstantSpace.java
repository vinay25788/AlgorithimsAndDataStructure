package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class ReArrangePostiveNegativeWithConstantSpace {
    public static void main(String[] args) {
        int[] a = {-1,2,4,-5,6,-9};
        reArrange(a);
        System.out.println(Arrays.toString(a));
    }
    public static void reArrange(int[] a)
    {
        int j=0,n = a.length;
        int temp =0;
        for(int i=0;i<n;i++)
        {
            if(a[i]<0)
            {
                if(i != j)
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;

                }
                j++;
            }
        }
    }
}
