package practice.datastructure.array.searching;

import java.util.Arrays;

public class FrequencyCount {
    public static void main(String[] args) {
        int[] a ={1,1,1,2,2,2,3,3,4,5,6};
        count(a,6);
        int[] b ={1,1,1,2,2,2,3,3,4,5,6};
        countWithIndex(b);
    }
    public static void count(int[] a,int n)
    {
        int len = a.length;
        int[] hash = new int[n];

        for(int i=0;i<len;i++)
            hash[a[i]-1]++;
        System.out.println(Arrays.toString(hash));
        for(int i=0;i<n;i++)
            System.out.println((i+1)+" "+hash[i]);
    }

    public static void countWithIndex(int[] a)
    {
        int n = a.length;

        for(int i=0;i<n;i++)
            a[i] = a[i]-1;

        for(int i=0;i<n;i++)
            a[a[i]%n] +=n;
        System.out.println();
        for(int i=0;i<n;i++)
        {
            if(a[i]/n >0)
            System.out.println((i+1)+" "+a[i]/n);
        }
    }
}
