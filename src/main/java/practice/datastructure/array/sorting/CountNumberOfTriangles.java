package practice.datastructure.array.sorting;

import java.util.Arrays;

public class CountNumberOfTriangles {
    public static void main(String[] args) {
        int[] a = { 4, 3, 5, 7, 6 };
        countTriangles(a);
    }
    public static void countTriangles(int[] a)
    {
        Arrays.sort(a);
        int n = a.length,count =0;
        for(int i=n-1;i>=0;i--)
        {
            int l =0,r = i-1;
            while(l<r)
            {
                if(a[l] +a[r]>a[i])
                {
                    count+=r-l;
                    r--;
                }
                else
                    l++;
            }
        }
        System.out.println(count);
    }
}
