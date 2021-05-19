package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class ReArrangePositiveAndNegative {
    public static void main(String[] args) {
        int[] a= new int[]{-12, 11, -13, -5, 6, -7, 5, -3, -6};
        reArrange(a);
        System.out.println(Arrays.toString(a));
    }
    public static void reArrange(int[] a)
    {
        int i=0;
        int j = a.length-1;
        int n = a.length-1;
        while( true)
        {
            while(a[i]<0 && i<n)
            i++;
            while(a[j]>0 && j>=0)
                j--;
            if(i<j)
            {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;

            }
            else
                break;
        }
    }
}
