package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.*;

public class SortBasedOnSequenceInSecondArray {
    public static void main(String[] args) {
        int[] a = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8, 7, 5, 6, 9, 7, 5 };
        int[] sequence = {2, 1, 8, 3,4};
        sortBasedOnSequence(a, sequence);
    }

    public static void sortBasedOnSequence(int[] a, int[] sequence) {
        Arrays.sort(a);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++)
        {
            if(map.containsKey(a[i]))
                map.put(a[i],map.get(a[i])+1);
            else
                map.put(a[i],1);
        }
        for(int i=0;i<sequence.length;i++)
        {
            if(map.containsKey(sequence[i]))
            {
                int len = map.get(sequence[i]);
                for(int j=0;j<len;j++)
                    System.out.print(" "+sequence[i]);

                map.remove(sequence[i]);
            }
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            int val = entry.getValue();
            for(int i=0;i<val;i++)
                System.out.print( " "+entry.getKey());
        }




    }
}
