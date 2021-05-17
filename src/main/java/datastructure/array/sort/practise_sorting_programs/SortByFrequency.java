package datastructure.array.sort.practise_sorting_programs;

import java.util.*;

public class SortByFrequency {
    public static void main(String[] args) {
        int[] a ={4,2,1,1,5,7,7,9,8,8,8,8};
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

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry:map.entrySet())
            entryList.add(entry);

        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {

                if(o1.getValue() == o2.getValue())
                    return o2.getKey() - o1.getKey();

                return o2.getValue()-o1.getValue();

            }
        });

        for(Map.Entry<Integer,Integer> entry:entryList)
            System.out.println(entry.getKey()+"---> "+entry.getValue());



    }
}
