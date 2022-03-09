package datastructure_pattern.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenateAllString {
    public static List<Integer> findSubstring(String s, String[] words) {

        if(s.isEmpty() || words.length ==0 || words[0].length() ==0 )
            return new ArrayList<>();

        Map<String,Integer> wordMap = new HashMap<>();

        for(String word:words)
        {
            wordMap.put(word,wordMap.getOrDefault(word,0)+1);
        }

        int sLen = s.length();
        int n = words.length, wLen = words[0].length();

        int targetLen = n*wLen;

        List<Integer> res = new ArrayList<>();

        for(int i=0;i<= sLen-targetLen;i++)
        {
            String sub = s.substring(i,i+targetLen);
            if(concatenate(sub,wordMap,wLen))
                res.add(i);

        }

        return res;

    }

    public static boolean concatenate(String s,Map<String,Integer> map,int wLen)
    {
        Map<String,Integer> seeMap = new HashMap<>(map);

        for(int i=0;i<=s.length()-wLen;i+=wLen)
        {
            String sub = s.substring(i,i+wLen);
            int freq = seeMap.get(sub);

            if(freq<0)
                return false;
            else
            {
                seeMap.put(sub,freq-1);
                if(seeMap.get(sub) ==0)
                    seeMap.remove(sub);
            }
        }
        return seeMap.isEmpty();
    }

    public static void main(String[] args) {
        String s="barfoothefoobarman";
        String words[] ={"foo","bar"};
        System.out.println(findSubstring(s,words));
    }
}
