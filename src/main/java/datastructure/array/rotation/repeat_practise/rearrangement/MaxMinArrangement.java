package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class MaxMinArrangement {
    public static void main(String[] args) {
        int[] a = new int[] {2,5,7,8};
        reArrangement(a);
        System.out.println(Arrays.toString(a));
    }
    public static void reArrangement(int[] a)
    {
        int n = a.length;
        int max_id = n-1, min_id = 0;
        int max_ele = a[n-1]+1;
        for(int i=0;i<n;i++)
        {
            if(i%2 ==0)
            {
                a[i]+= (a[max_id--] % max_ele)*max_ele;
            }
            else
                a[i]+= (a[min_id++] %max_ele)*max_ele;
        }
        System.out.println(Arrays.toString(a));
        for(int i=0;i<n;i++)
            a[i] = a[i]/max_ele;
    }
}
