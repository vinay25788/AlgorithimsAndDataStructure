package practice.datastructure.array.arrangement;

import java.util.HashMap;
import java.util.Map;

public class EqualNumberOf0s1s {
    public static void main(String[] args) {
        int arr[] = { 1, 0, 0, 1, 0, 1, 1 };

        find(arr);
    }
    public static void find(int[] a)
    {
       int maxLength = 0, endingIndex =0;
       Map<Integer,Integer> map = new HashMap<>();
       int n = a.length;
       for(int i=0;i<n;i++)
           a[i] = (a[i] == 0? -1:1);
       int sum =0;
       for(int i=0;i<n;i++)
       {
           sum+=a[i];
           if(sum ==0)
           {
               maxLength = i+1;
               endingIndex = i;
           }
           if(map.containsKey(sum))
           {
               if(maxLength<i- map.get(sum))
               {
                   maxLength = map.get(sum);
                   endingIndex = i;
               }
           }
           else
               map.put(sum,i);
       }
       for(int i=0;i<n;i++)
           a[i] = (a[i] == -1)?-1:1;
       int start = endingIndex - maxLength +1;
        System.out.println(start +" to  "+endingIndex);
    }

}
