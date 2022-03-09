package practice.String;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
    public static void main(String[] args) {
        String st = "geeksforgeeks";
        longestUniqueSubstring(st);
    }

    public static void longestUniqueSubstring(String st) {
        int start = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < st.length(); i++) {
            if (map.containsKey(st.charAt(i)))
                start = Math.max(start, map.get(st.charAt(i)) + 1);
            map.put(st.charAt(i), i);
            maxLength = Math.max(maxLength,i-start+1);
        }
        System.out.println(maxLength);

    }
}
