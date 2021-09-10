package practice.datastructure.array.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapRequiredToSortAnArray {
    public static void main(String[] args) {
        int[] a ={ 101, 758, 315, 730, 472,
                619, 460, 479 };
        countSwap(a);
    }
    public static void countSwap(int[] a)
    {
        Map<Integer,Integer> map = new HashMap<>();
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            map.put(a[i],i);
        }
        Arrays.sort(a);
        for(int i=0;i<n;i++)
            a[i] = map.get(a[i]);

        map = null;
        int count=0;
        for(int i=0;i<n;i++)
        {
            int val = a[i];
            if(val <0)
                continue;
            while(val != i)
            {
                int newVal = a[val];
                a[val] = -1;
                val = newVal;
                count++;
            }
            if(a[i] != -1)
                a[i] = -1;
        }
        System.out.println(count);
    }
}
