package datastructure_pattern.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestLengthSubstringWitoutRepeating {


    public static int lengthOfLongestSubstring(String s) {

        if(s.isEmpty())
            return 0;
        if(s.length() ==1)
            return 1;

        int i = 0, j = 0;

        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int maxLength = Integer.MIN_VALUE;
        while (j < n) {
            if (!map.containsKey(s.charAt(j)))
            {
                map.put(s.charAt(j), 1);

            }
            else {


                if (maxLength < map.size())
                    maxLength = map.size();
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                boolean flag = false;
                while (i<j && !flag) {
                    if(map.get(s.charAt(i))<1)
                        flag = true;
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));
                    i++;
                }


            }

            j++;
        }

        if(i==0)
            return s.length();

        return Math.max(maxLength,map.size());
    }

    public static void main(String[] args) {
        String s = "jbpnbwwd";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
