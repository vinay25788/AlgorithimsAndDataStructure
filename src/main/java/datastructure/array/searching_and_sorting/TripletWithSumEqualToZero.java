package datastructure.array.searching_and_sorting;

import java.util.Arrays;

public class TripletWithSumEqualToZero {
    public static void main(String[] args) {
        int[] a={0, -1, 2, -3, 1};
        findTriplet(a);
    }
    public static void findTriplet(int[] a)
    {
        int n = a.length;
        Arrays.sort(a);
        for(int i=0;i<n;i++)
        {
            int l = i+1;
            int r = n-1;
            while(l < r)
            {
                if( a[i]+a[l]+a[r]==0)
                {
                    System.out.println(a[i]+" "+a[l]+" "+a[r]);
                    return;
                }
                else if ( a[i]+a[l]+a[r]<0)
                    l++;
                else
                    r--;

            }
        }
    }
}
