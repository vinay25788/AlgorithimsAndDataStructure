package datastructure_pattern.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKCharacter {
    static public int lengthOfLongestSubstringTwoDistinct(String s) {

        if(s.isEmpty())
            return 0;

        int i=0,j=0,maxLength = Integer.MIN_VALUE;
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        while(j<n)
        {
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
          if(map.size() ==2) {
              int length = j - i + 1;
              if (length > maxLength) {
                  maxLength = length;
              }
          }
            if (map.size() > 2)
            {


                while(map.size()>2)
                {

                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i)) ==0)
                        map.remove(s.charAt(i));
                    i++;
                }
            }
            j++;
        }

        return maxLength;

    }

    public static void main(String[] args) {
        String s = "ccaabbb";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }
}
