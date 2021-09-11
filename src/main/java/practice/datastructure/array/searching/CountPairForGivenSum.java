package practice.datastructure.array.searching;

import java.util.HashMap;
import java.util.Map;

public class CountPairForGivenSum {
    public static void main(String[] args) {
   int[] a ={ 1, 5, 7, -1, 5 };
   int sum =6;
   countPair(a,sum);

    }
    public static void countPair(int[] a,int sum)
    {
        Map<Integer,Integer> map = new HashMap<>();
        int n = a.length;

        int twiceCount =0;
        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(a[i]))
                map.put(a[i],1);
                  else
                    map.put(a[i],map.get(a[i])+1);

        }

        for(int i=0;i<n;i++)
        {
            if(map.get(sum-a[i]) != null)
            {
               twiceCount +=map.get(sum - a[i]);
            }

            if(sum - a[i] == a[i])
                twiceCount--;
        }

        System.out.println();
        System.out.println(twiceCount/2);

    }
}
