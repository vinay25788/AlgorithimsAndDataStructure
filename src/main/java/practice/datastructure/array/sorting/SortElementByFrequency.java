package practice.datastructure.array.sorting;

import java.util.*;

public class SortElementByFrequency {
    public static void main(String[] args) {
        int[] a ={ 2, 5, 2, 8, 5, 6, 8, 8 };
        sortByFrequency(a);
    }
    public static void sortByFrequency(int[] a)
    {
        Map<Integer,Integer> map = new HashMap<>();
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue() == o2.getValue())
                    return o2.getKey() - o1.getKey();
                else
                    return o2.getValue() - o1.getValue();
            }
        });

        for(Map.Entry<Integer,Integer> entry:list)
        {
            int val = entry.getValue();

            for(int i=0;i<val;i++)
              System.out.print(entry.getKey()+" ");
        }
    }
}
