package datastructure.array.pracitise.array.orderstatics;

import java.util.*;

public class FindKMostOccuredElements {
    public static void main(String[] args) {
        int[] a ={1,1,1,1,2,2,2,3,4};
        int k =2 ;
        findNumbers(a,k);
    }
    public static void findNumbers(int[] a,int k)
    {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++)
        {
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue())
                    return o2.getKey() - o1.getKey();
                else
                    return o2.getValue()
                            - o1.getValue();
            }
        });

        for(int i=0;i<k;i++)
            System.out.println(list.get(i).getKey());
    }
}
