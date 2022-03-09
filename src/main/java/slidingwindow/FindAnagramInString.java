package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FindAnagramInString {
    public static void main(String[] args) {
        String s ="AAABABAA";
        String pat = "AABA";

        System.out.println(findAnagramOccurance(s,pat));
    }

    public static int findAnagramOccurance(String s,String pat)
    {
        Map<Character,Integer> map = new HashMap<>();

        char[] pa = pat.toCharArray();

        for(Character ch: pa)
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        System.out.println(map);
        int count = map.size();
        int ans =0;
        int i=0,j=0;
        int n = s.length();
        int k = pat.length();
        while(j<n)
        {
            if(map.containsKey(s.charAt(j)))
            {
                map.put(s.charAt(j),map.get(s.charAt(j))-1);


                if(map.get(s.charAt(j))==0)
                    count--;
            }

            if((j-i+1)<k)
                j++;
            else if ( (j-i+1)==k)
            {
                if(count ==0)
                    ans++;
                if(map.containsKey(s.charAt(i)))
                {
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                    if(count ==0)
                        count++;

                }
                i++;
                j++;

            }
        }
        return ans;
    }
}
