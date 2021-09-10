package practice.datastructure.array.sorting;

import java.util.Arrays;

public class CountPairWithDiffernceK {
    public static void main(String[] args) {
        int[] a ={1, 5, 3, 4, 2};
        countPair(a,3);
    }
    public static void countPair(int[] a,int k)
    {
        Arrays.sort(a);
        int l =0,r=0,n=a.length,count=0;
        while(r<n)
        {
            if(a[r]-a[l]==k)
            {
                count++;
                l++;
                r++;
            }
            else if (a[r]-a[l]>k)
                l++;
            else
                r++;
        }
        System.out.println(count);
    }
}
