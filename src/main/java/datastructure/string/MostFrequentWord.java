package datastructure.string;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentWord {
    public static void main(String[] args) {
        String[] st = { "geeks", "for", "geeks", "a",
                "portal", "to", "learn", "can", "be",
                "computer", "science", "zoom", "yup",
                "fire", "in", "be", "data", "geeks" };
        findMostFrequent(st);
    }
    public static void findMostFrequent(String[] st)
    {
        Map<String,Integer> map = new HashMap<>();
        int max =0;
        for(String s:st) {
            map.put(s, map.getOrDefault(s, 1) + 1);
            if(max<map.get(s))
            {
                max = map.get(s);
            }
        }

        for(Map.Entry<String,Integer> entry: map.entrySet())
        {
            if(entry.getValue()== max)
                System.out.println(entry.getKey() +" "+max);
        }

    }
}
