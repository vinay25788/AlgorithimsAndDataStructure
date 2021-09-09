package practice.datastructure.array.rotation;

import java.util.Arrays;

public class MaximumSumIndexIntoElement {
    public static void main(String[] args) {
        int a[] = {8, 3, 1, 2};
        maximumSum(a);


        int arr[] = { 2, 0, 1, 4, 5, 3 };


       // System.out.println(Arrays.toString(arr));
    }
    public static void maximumSum(int[] a)
    {
        int n = a.length;

        int curSum=0;
        for(int i=0;i<n;i++)
            curSum+=a[i];
        int curVal =0;

        for(int i=0;i<n;i++)
            curVal+=i*a[i];

        int maxValue = curVal;
        int nextValue =0;
        for(int i=1;i<n;i++)
        {
            nextValue = curVal - (curSum-a[i-1]) + a[i-1]* (n-1);
            curSum = nextValue;
            if(nextValue>maxValue)
                maxValue = curSum;

        }
        System.out.println(" maximum value "+ maxValue);

    }
}
