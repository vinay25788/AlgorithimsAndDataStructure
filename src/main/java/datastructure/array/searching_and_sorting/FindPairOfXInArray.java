package datastructure.array.searching_and_sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPairOfXInArray {
    public static void main(String[] args) {
        int[] a ={1,2,3,5,7,8,9};
        int x = 12;
        findPair(a,x);
        findPairUsingSet(a,x);
    }
    public static void findPairUsingSet(int[] a,int x)
    {
        Set<Integer> set = new HashSet<>();
        int sum =0,n = a.length;
        for(int i=0;i<n;i++)
        {
            int remaining = x-a[i];
            if(set.contains(remaining))
            {
                System.out.println(a[i] +" "+remaining);
            }
            else
                set.add(a[i]);
        }

    }
    public static void findPair(int[] a,int x)
    {

        Arrays.sort(a);
        int l =0,r = a.length-1;
        while(l<r)
        {
            if(a[l]+a[r] == x)
            {
                System.out.println(a[l]+" "+a[r]+" sum = "+(a[l]+a[r]));
                l++;
                r--;
            }
            else if(a[l]+a[r]<x)
                l++;
            else
                r--;

        }

    }
}
