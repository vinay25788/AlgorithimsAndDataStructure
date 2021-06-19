package datastructure.string;

import java.util.LinkedList;
import java.util.Queue;

public class QueueBasedApproachForFIrstNonRepeatingCharacter {
    public static void main(String[] args) {
        String st = "aabc";
        find(st);
    }
    public static void find(String st)
    {
        int[] charCount = new int[26];
        Queue<Character> que = new LinkedList<>();

        for(int i=0;i<st.length();i++)
        {
            char ch = st.charAt(i);

            que.add(ch);
            charCount[ch-'a']++;
            while(!que.isEmpty())
            {
                if(charCount[que.peek()-'a']>1)
                    que.remove();
                else
                {
                    System.out.println(que.peek());
                    break;
                }
            }
            if(que.isEmpty())
                System.out.println("-1");

        }

    }
}
