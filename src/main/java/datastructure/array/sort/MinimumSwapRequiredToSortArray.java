package datastructure.array.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapRequiredToSortArray {
    public static void main(String[] args) {
        int[] a = {4,2,1,3};
        System.out.println("minimum sort required to sort array -------->"+minimumSwap(a));
    }
    public static int minimumSwap(int[] a)
    {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++)
        {
            map.put(a[i],i);
        }
        Arrays.sort(a);

        for(int i=0;i<a.length;i++)
        {
            a[i] = map.get(a[i]);
        }
        map = null;

        int swap = 0;
        for(int i=0;i<a.length;i++)
        {
            int val = a[i];
            if(val < 0 ) continue;;
            while(val != i)
            {
                int new_val = a[val];
                a[val] = -1;
                val = new_val;
                swap++;
            }
            a[i] = -1;
        }
        return swap;

    }
}
