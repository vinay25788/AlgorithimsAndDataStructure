package datastructure_pattern.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKRepeatingCharacter_LeetCode395 {
    static public int longestSubstring(String s, int k) {

        int i=0,j=0,n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        int count =0;
        while(j<n-1)
        {
            if(s.charAt(j) == s.charAt(j+1))
            {
                count++;
                j++;
            }
            else if (count+1>=k)
            {
                count =0;
                int length = j-i+1;
                if(maxLength<length)
                    maxLength = length;

            }
            else if(count < k)
            {
                i=j;
                j++;
            }


        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "ababbc";

        int k = 2;
        System.out.println(longestSubstring(s,k));
    }
}
