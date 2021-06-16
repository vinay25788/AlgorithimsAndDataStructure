package datastructure.string;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumSumSqaureAfterRemovingKCharacter {
    public static void main(String[] args) {
        String st = "abbccc";
        int k = 2;
        findSquareSum(st,k);
    }
    public static void findSquareSum(String st,int k)
    {
        int[] count = new int[26];

        for(int i=0;i<st.length();i++)
            count[st.charAt(i)-'a']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<26;i++)
        {
            if(count[i] !=0)
                pq.add(count[i]);
        }

        int result =0;
        while(k!=0)
        {
            pq.add(pq.poll()-1);
            k--;
        }

        while(!pq.isEmpty())
        {
            result+=pq.peek()*pq.poll();
        }
        System.out.println(" result ---->"+result);
    }
}
