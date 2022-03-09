package datastructure_pattern.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimuWindowSubstring {
    public static String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int count = map.size();

        int start = -1, i = 0, j = 0;

        int n = s.length();
        int minLength = Integer.MAX_VALUE;

        while (j < n) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0)
                    count--;
            }


            if (count == 0) {

                while (count ==0 ) {
                    int length = j - i + 1;
                    if (length < minLength) {
                        start = i;
                        minLength = j - i + 1;
                    }

                    if (map.containsKey(s.charAt(i))) {
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                        if (map.get(s.charAt(i)) > 0)
                            count++;

                    }
                    i++;
                }

            }
            j++;
        }

        return s.substring(start, start + minLength);

    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }
}
