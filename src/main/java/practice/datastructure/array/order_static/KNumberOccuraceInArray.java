package practice.datastructure.array.order_static;

import java.util.*;

public class KNumberOccuraceInArray {
    public static void main(String[] args) {
        int[] a ={ 3, 1, 4, 4, 5, 2, 6, 1 };
        int k = 2;
        find(a,k);
    }
    public static void find(int[] a,int k)
    {
        Map<Integer,Integer> map = new HashMap<>();
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<Map.Entry<Integer,Integer>> (map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue() == o2.getValue())
                return o2.getKey() - o1.getKey();
                return o2.getValue()-o1.getValue();
            }
        });

        for(int i=0;i<k;i++)
        {
            System.out.println(entryList.get(i).getKey());
        }
    }
}
