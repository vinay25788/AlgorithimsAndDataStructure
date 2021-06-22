package datastructure.string;

import java.util.HashMap;
import java.util.Map;

public class FindWinner {
    public static void main(String[] args) {
        String[] votes = {"john", "johnny", "jackie",
                "johnny", "john", "jackie",
                "jamie", "jamie", "john",
                "johnny", "jamie", "johnny",
                "john"};

        findWinner(votes);
    }

    public static void findWinner(String[] votes) {
        Map<String, Integer> map = new HashMap<>();

        for (String vote : votes) {
            map.put(vote,map.getOrDefault(vote,0)+1);
        }
        int maxVotesInMap =0;
        String winner="";
        for(Map.Entry<String,Integer> entry:map.entrySet())
        {
            String key = entry.getKey();
            Integer value = entry.getValue();
             if(value>maxVotesInMap)
             {
                 maxVotesInMap = value ;
                 winner = key;
             }
             else if ( value == maxVotesInMap && winner.compareTo(key)>0)
                winner = key;

        }
        System.out.println(winner);
    }
}
