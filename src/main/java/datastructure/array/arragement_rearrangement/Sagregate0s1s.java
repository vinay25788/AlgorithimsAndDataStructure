package datastructure.array.arragement_rearrangement;

import java.util.Arrays;

public class Sagregate0s1s {
    public static void main(String[] args) {
        int[] a ={1,0,1,0,0,1,0,1,1};
        sagregate(a);
        System.out.println(Arrays.toString(a));
    }
    public static void sagregate(int[] a)
    {
        int n = a.length;
        int left =0, right = n-1;
        while(left<right)
        {
            if(a[left] ==0 && left < right)
                left++;
            if(a[right] ==1 && left<right)
                right--;
            if(left <right)
            {
                a[left] =0;
                a[right] =1;
                left++;
                right--;
            }
        }
    }
}

