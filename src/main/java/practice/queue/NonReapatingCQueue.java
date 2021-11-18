package practice.queue;// Java Program for a Queue based approach
// to find first non-repeating character

import java.util.LinkedList;
import java.util.Queue;

public class NonReapatingCQueue {
    final static int MAX_CHAR = 26;

    // function to find first non repeating
    // character of stream
    static void firstNonRepeating(String str)
    {
        // count array of size 26(assuming
        // only lower case characters are present)
        int[] charCount = new int[MAX_CHAR];

        // Queue to store Characters
        Queue<Character> q = new LinkedList<Character>();

        // traverse whole stream
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // push each character in queue
            q.add(ch);

            // increment the frequency count
            charCount[ch - 'a']++;

            // check for the non repeating character
            while (!q.isEmpty()) {
                if (charCount[q.peek() - 'a'] > 1)
                    q.remove();
                else {
                    System.out.print(q.peek() + " ");
                    break;
                }
            }
            if (q.isEmpty())
                System.out.print(-1 + " ");
        }
        System.out.println();
    }

    // Driver function
    public static void main(String[] args)
    {
        String str = "aabc";
        firstNonRepeating(str);
    }
}
// This code is Contributed by Sumit Ghosh
