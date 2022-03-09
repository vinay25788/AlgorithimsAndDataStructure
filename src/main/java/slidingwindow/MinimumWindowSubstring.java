package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        if(s.length()<t.length())
            return "";
        int i=0,j=0,minLength = Integer.MAX_VALUE;
        int n = s.length();
        int count =0;
        Map<Character,Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        for(Character cha : t.toCharArray())
        {
            map.put(cha,map.getOrDefault(cha,0)+1);
        }
        count = map.size();
        int start = 0, end =0;
        while(j<n)
        {
            if(map.containsKey(ch[j]))
            {
                map.put(ch[j],map.get(ch[j])-1);

                if(map.get(ch[j]) == 0)
                    count--;
            }
            if(count ==0)
            {
                while( count == 0)
                {
                    int length = j-i+1;
                    if(minLength>length)
                    {
                        minLength = length;
                        start = i;
                        end = j;

                    }

                    if( map.containsKey(ch[i]))
                    {
                        if  (map.get(ch[i])<=0)
                        {
                            map.put(ch[i],map.get(ch[i])+1);
                            if(map.get(ch[i])>0)
                                count++;
                        }
                    }
                    i++;
                }
            }
            j++;

        }
        if(minLength == Integer.MAX_VALUE)
            return "";
        return s.substring(start,end+1);
    }

    public static void main(String[] args) {
       String st = "a", t = "a";
        System.out.println(minWindow(st,t));
    }
}
