package practice.datastructure.array.searching;

import java.util.Arrays;

public class TripletWithSumEqualTo0 {
    public static void main(String[] args) {




        int[] a = {0, -1, 2, -3, 1};
        findTriplet(a);
    }
    public static void findTriplet(int[] a)
    {
        Arrays.sort(a);
        int n = a.length;
        for(int i=0;i<n-1;i++)
        {
            int l = i+1;
            int r = n-1;
            int x = a[i];
            while(l<r)
            {
                if(a[l]+a[r]+x==0)
                {
                    System.out.println(a[l]+" "+a[r]+" "+x);
                    l++;
                    r--;
                }
                else if (a[l]+a[r]+x>0)
                {
                    r--;
                }
                else
                    l++;
            }
        }
    }
}
