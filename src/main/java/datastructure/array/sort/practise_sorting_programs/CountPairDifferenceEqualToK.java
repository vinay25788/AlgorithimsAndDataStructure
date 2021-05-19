package datastructure.array.sort.practise_sorting_programs;

import java.util.Arrays;

public class CountPairDifferenceEqualToK {
    public static void main(String[] args) {
        int[] a = {1, 5, 3, 4, 2};
        int k = 3;
        findPair(a,k);
    }
    public static void findPair(int[] a,int k)
    {
        Arrays.sort(a);

        int n = a.length;
        int l =0;
        int r =1;
        int count=0;
        while(r < n)
        {
            if(a[r]-a[l] ==k)
            {
                count++;
                r++;
                l++;
            }
            else if( a[r]-a[l]>k)
                l++;
            else
                r++;
        }

        System.out.println(count);
    }
}
