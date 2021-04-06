package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class ReArrangeHighestLowestPattern {
    public static void main(String[] args) {
        int[] a= new int[]{4,2,1,6,7,8,9};
        reArrange(a);
        System.out.println("After reArrangement "+Arrays.toString(a));
    }
    public static void reArrange(int[] a)
    {
        Arrays.sort(a);
        int l=0,n = a.length;
        int index=0;
        int tempArr[] = new int[n];
        for(int i=0,j=n-1;i<=n/2 || j>n/2; i++,j--)
        {
            if(index<n)
            {
               tempArr[index] = a[i];
               index++;
            }
            if(index<n)
            {
                tempArr[index] = a[j];
                index++;
            }

        }
        for(int i=0;i<n;i++)
            a[i] = tempArr[i];
    }
}
