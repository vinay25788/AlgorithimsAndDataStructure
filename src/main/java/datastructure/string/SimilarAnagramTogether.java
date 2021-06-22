package datastructure.string;

import java.util.*;

public class SimilarAnagramTogether {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("geeksquiz","geeksforgeeks","abcd","forgeeksgeeks","zuiqkeegs","cat");
        sort(list);
    }
    public static void sort(List<String> list)
    {
        Map<String,List<String>> map = new HashMap<>();
        for(String an:list)
        {
           char ch[] = an.toCharArray();
           Arrays.sort(ch);
            String sorted = String.valueOf(ch);
            if(map.get(sorted) != null)
            {
                List<String> ls = map.get(sorted);
                ls.add(an);
                map.put(sorted,ls);
            }
            else
            {
                List<String> li = new LinkedList<>();
                li.add(an);
                map.put(sorted,li);
            }
        }

        for(Map.Entry<String,List<String>> entry:map.entrySet())
        {
            System.out.println(" "+ entry.getValue());
        }
    }
}
