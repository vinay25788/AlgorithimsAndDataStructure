package datastructure.array.optimization_problems;

import java.util.Arrays;

public class MinimumDifferencePair {
    public static void main(String[] args) {
        int[] a ={1, 5, 3, 19, 18, 25};
        findMinimumDifference(a);
    }
    public static void findMinimumDifference(int[] a)
    {
        Arrays.sort(a);
        int minDiff = Integer.MAX_VALUE;
        int n = a.length;
        for(int i=0;i<n-2;i++)
        {
            minDiff = Math.min(minDiff,a[i+1]-a[i]);

        }
        System.out.println(minDiff);
    }

}
