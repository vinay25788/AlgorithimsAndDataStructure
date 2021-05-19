package datastructure.array.arragement_rearrangement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapRequiredToSortAnArray {
    public static void main(String[] args) {
        int[] a ={3,1,2,4};
        System.out.println(findMinSwap(a));
    }

    public static int findMinSwap(int[] a)
    {
     int n= a.length;
     Map<Integer,Integer> m = new HashMap<>();

     for(int i=0;i<n;i++)
         m.put(a[i],i);

        Arrays.sort(a);

        for(int i=0;i<n;i++)
            a[i] = m.get(a[i]);

        int swap=0;
        for(int i=0;i<n;i++)
        {
            if(a[i] < 0)
                continue;
            int val = a[i];
            while(val != i)
            {
                int newValue = a[val];
                a[val] = -1;
                val = newValue;
                swap++;
            }
            a[i] =-1;
        }

        return swap;
    }
}
