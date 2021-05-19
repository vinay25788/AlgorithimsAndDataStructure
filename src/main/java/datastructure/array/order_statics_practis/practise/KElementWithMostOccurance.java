package datastructure.array.order_statics_practis.practise;

import java.util.*;

public class KElementWithMostOccurance {
    public static void main(String[] args) {
        int a[]= {1,2,3,4,5,3,2,1,2,4,4};
        int k = 2;
        findKElement(a,k);
    }
    public static void findKElement(int[] a,int k)
    {
        int n= a.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue() == o2.getValue())
                    return o2.getKey() - o1.getKey();
                else
                    return o2.getValue() - o1.getValue();
            }
        });

        for(int i=0;i<k;i++)
            System.out.println(list.get(i).getKey());

    }
}
