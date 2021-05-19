package datastructure.array.searching_and_sorting;

import java.util.HashMap;
import java.util.Map;

public class PairOfSumFromTwoUnsortedArray {
    public static void main(String[] args) {
        int a1[] = { 1, 0, -4, 7, 6, 4 };
        int a2[] = { 0, 2, 4, -3, 2, 1 };
        int x = 8;
        findPair(a1,a2,x);
    }
    public static void findPair(int[] a,int[] b,int x)
    {
        Map<Integer,Integer> map = new HashMap<>();
        int n = a.length;
        for(int i=0;i<n;i++)
            map.put(a[i],0);
        int m = b.length;
        for(int i=0;i<m;i++)
            if(map.containsKey(x-b[i]))
                System.out.println(" "+b[i]+" "+(x-b[i]));
    }
}
