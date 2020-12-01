package datastructure.array.sort;

import java.util.*;

public class SortByFrequencyJavaMap {
    public static void main(String[] args) {
        int[] a = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int el:a)
        {
            map.put(el,map.getOrDefault(el,0)+1);
            list.add(el);
        }

        Comparator comparator = new Comparator(map);
        Collections.sort(list,comparator);
        System.out.println(list.toString());
    }
}

class Comparator implements java.util.Comparator<Integer>
{

    private final Map<Integer,Integer> map;

    Comparator(Map<Integer, Integer> map) {
        this.map = map;
    }


    @Override
    public int compare(Integer o1, Integer o2) {


        int freq = map.get(o2).compareTo(map.get(o1));
        int val = o1.compareTo(o2);
        if(freq == 0)
            return val;
        else
            return freq;

    }
}
