package practice.String;

import java.util.*;

public class WinnerOfElection {
    public static void main(String[] args) {
        String[] votes = { "john", "johnny", "jackie",
                "johnny", "john", "jackie",
                "jamie", "jamie", "john",
                "johnny", "jamie", "johnny",
                "john" };
        findWinner(votes);
    }
    public static void findWinner(String[] votes)
    {
        Map<String,Integer> map = new HashMap<>();
        int n = votes.length;
        for(String st: votes)
        {
            map.put(st,map.getOrDefault(st,1)+1);
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() == o2.getValue())
                return o1.getKey().compareTo(o2.getKey());
                return o2.getValue()-o1.getValue();
            }
        });

        int maxValue =0;
            String winner = "";
        for(Map.Entry<String,Integer > entry:list)
        {
            int vote = entry.getValue();
            String key = entry.getKey();
            if(maxValue<vote)
            {
                maxValue = vote;
                winner = key;

            }
            else if ( vote == maxValue && winner.compareTo(key)>0)
                winner = key;

        }
        System.out.println(" winner "+winner);
        System.out.println(map);
        System.out.println(list.get(0).getKey());

    }
}
