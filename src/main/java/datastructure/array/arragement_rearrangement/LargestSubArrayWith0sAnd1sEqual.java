package datastructure.array.arragement_rearrangement;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWith0sAnd1sEqual {
    public static void main(String[] args) {
        int[] a ={0,1,0,1,0,0,1,1};
        find(a);
    }
    public static void find(int[] a)
    {
        int n= a.length;
        int sum=0,ending_index = 0,max_lenghth=0;

        for(int i=0;i<n;i++)
            a[i] = (a[i] ==0)?-1:1;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            sum+=a[i];
            if(sum ==0)
            {
                max_lenghth = i+1;
                ending_index = i;
            }
                if(map.containsKey(sum+n))
                {
                    if(max_lenghth < i-map.get(sum+n))
                    {
                        max_lenghth = i-map.get(sum+n);
                        ending_index = i;
                    }
                }
        }

        for(int i=0;i<n;i++)
            a[i] = (a[i] ==-1)? 0:1;


        int starting_index = ending_index - max_lenghth+1;
        System.out.println("starting "+starting_index+ "  "+ending_index);
    }
}
