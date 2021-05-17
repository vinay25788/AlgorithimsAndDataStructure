package datastructure.array.sort.practise_sorting_programs;

import java.util.HashMap;
import java.util.Map;

public class MergeTwoArray {
    public static void main(String[] args) {
        int a[] = {1, 3, 5, 7}, b[] = {2, 4, 6, 8};
        merge(a,b);
    }
    public static void merge(int[] a,int [] b)
    {
        Map<Integer,Boolean> mp = new HashMap<>();
        for(int i=0;i<a.length;i++)
            mp.put(a[i],true);
        for(int i=0;i<b.length;i++)
            mp.put(b[i],true);

        for(Map.Entry<Integer,Boolean> entry:mp.entrySet())
        {
            System.out.print(" "+entry.getKey());
        }
    }
}
