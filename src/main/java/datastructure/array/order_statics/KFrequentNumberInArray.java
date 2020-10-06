package datastructure.array.order_statics;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KFrequentNumberInArray {
    public static void main(String[] args) {
        int a[] = { 3, 1, 4, 4, 5, 2, 6, 1 };
        int k =5;
        findKFrequentNumbers(a,k);
    }
    public static void findKFrequentNumbers(int[] a,int k)
    {
        Map<Integer,Integer> map = new HashMap<>();
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
                (x,y)-> x.getValue().equals(y.getValue())?
                            Integer.compare(y.getKey(),x.getKey()):
                             Integer.compare(y.getValue(),x.getValue())
        );

        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            pq.add(entry);
        }
        System.out.println(pq);
        for(int i=0;i<k;i++)
        {
            System.out.println(pq.poll().getKey());
        }
    }
}

