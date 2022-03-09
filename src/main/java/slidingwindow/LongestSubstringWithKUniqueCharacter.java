package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacter {

    static  public int lengthOfLongestSubstringKDistinct(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int i=0,j=0,ans = Integer.MIN_VALUE;
        while(j<n)
        {
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            if(map.size() <=k)
            {
                ans = Math.max(ans,j-i+1);

            }
            if(map.size()>k)
            {
                while(map.get(s.charAt(i))>1)
                {
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));
                    i++;
                }
            }
            j++;
        }

        if(ans == Integer.MIN_VALUE)
            return 0;

        return ans;


    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("aa",2));
    }
}
