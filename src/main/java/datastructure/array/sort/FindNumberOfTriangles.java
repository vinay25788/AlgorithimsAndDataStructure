package datastructure.array.sort;

import java.util.Arrays;

public class FindNumberOfTriangles {

    public static void main(String[] args) {
        int[] a = { 4, 3, 5, 7, 6 };
        find(a);
    }
    public static void find(int[] a)
    {
        Arrays.sort(a);
        int count =0;

        int n = a.length;
        for(int i=n-1;i>=1;i--)
        {
            int l =0, r = i-1;
            while( l<r)
            {
                if(a[l]+a[r] > a[i])
                {
                    count += r-l;
                    r--;
                }
                else
                    l++;
            }
        }
        System.out.println("number of triangles "+count);
    }
}
