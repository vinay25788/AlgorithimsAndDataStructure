package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagramWithIndex {
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();

        int i=0,j=0,count=0;
        int n = s.length();
        int k = p.length();
        Map<Character,Integer> map = new HashMap<>();

        for( i=0;i<k;i++)
        {
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        }
        i=0;

        System.out.println(map);
        count = map.size();

        while(j<n)
        {
            if(map.containsKey(s.charAt(j)))
            {
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)-1);

                if(map.get(s.charAt(j)) == 0)
                    count--;

            }
            if(j-i+1<k)
                j++;
            else if( (j-i+1)==k)
            {
                if(count ==0)
                {
                    list.add(i);
                }

                if(map.containsKey(s.charAt(i)))
                {
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                       if(map.get(s.charAt(i))==1)
                           count++;
                }
                i++;
                j++;
            }
        }

        return list;

    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s,p));
    }
}