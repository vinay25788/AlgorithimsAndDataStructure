package practice.datastructure.array.sorting;

import java.util.Arrays;

public class SumCloseToZero {
    public static void main(String[] args) {
      int [] a=  {1, 60, -10, 70, -80, 85};
      calculateSum(a);
    }
    public static void calculateSum(int[] a)
    {
        Arrays.sort(a);
        int minDiff = Integer.MAX_VALUE;

       int l =0,n = a.length,r = n-1;
       int first =0,second =0,sum =0;
        while(l<r)
        {
            sum = a[l]+a[r];
            if(Math.abs(sum) <Math.abs(minDiff))
            {
                minDiff = a[l]+a[r];
                first = a[l];
                second = a[r];
                l++;
                r--;
            }
            else if (a[l]+a[r] >minDiff)
            {
                r--;
            }
            else
                l++;
        }
        System.out.println(minDiff+" first "+first+" second "+second);
    }
}
