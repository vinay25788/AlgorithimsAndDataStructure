package practice.datastructure.array.searching;

import java.util.HashSet;
import java.util.Set;

public class DoubleValueAfterSearch {
    public static void main(String[] args) {
        int[] a ={2, 3, 4, 10, 8, 1 };
        int k = 2;
        find(a,k);
        usingSet(a,k);
    }
    public static void find(int[] a,int k)
    {
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            if(a[i] == k)
                k = 2*k;

        }
        System.out.println(k);
    }

    public static void usingSet(int[] a,int k)
    {
        int n = a.length;
        Set<Integer> set= new HashSet<>();
        for(int i=0;i<n;i++)
            set.add(a[i]);

        for(int i=0;i<n;i++)
            if(set.contains(k))
                k=2*k;

        System.out.println("using set "+k);
    }
}
