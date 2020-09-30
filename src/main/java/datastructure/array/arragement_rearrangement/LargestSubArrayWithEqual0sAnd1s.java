package datastructure.array.arragement_rearrangement;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithEqual0sAnd1s {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 1, 0, 0, 1, 1, 1};
        findSubArray(a);
    }

    public static void findSubArray(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++)
            a[i] = (a[i] == 0) ? -1 : 1;

        int max_length = 0;
        int ending_index = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            sum+=a[i];
            if(sum ==0)
            {
                max_length = i+1;
                ending_index =i;
            }

            if(map.containsKey(sum+n))
            {
                if(max_length < i - map.get(sum+n))
                {
                    max_length = i-map.get(sum+n);
                    ending_index =i;
                }
            }
            else
                map.put(sum+n,i);

        }

        for(int i=0;i<n;i++)
            a[i] = (a[i] == -1 )? 0:1;

        int startingIndex = ending_index - max_length+1;
        System.out.println("starting index  "+startingIndex + " ending index     "+ending_index);
    }
}
