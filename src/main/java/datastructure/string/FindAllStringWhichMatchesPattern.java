package datastructure.string;

import java.util.HashSet;
import java.util.Set;

public class FindAllStringWhichMatchesPattern {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("abb");
        dict.add("abc");
        dict.add("xyz");
        dict.add("xyy");
        findMatchedWord(dict, "foo");
    }

    public static void findMatchedWord(Set<String> dict, String patt) {
        String res = "";
        for (String st : dict) {
            if (check(st, patt)) {
                res = st + " " + res;
            }
        }
        System.out.println(res);
    }

    public static boolean check(String st, String pat) {
        int[] chCount = new int[26];
        if (st.length() != pat.length())
            return false;
        int n = pat.length();
        for (int i = 0; i < n; i++) {
            if (chCount[(int) pat.charAt(i) - 'a'] == 0)
                chCount[(int) pat.charAt(i) - 'a'] = st.charAt(i);
            else if (chCount[(int) pat.charAt(i) - 'a'] != st.charAt(i))
                return false;
        }
        return true;
    }
}
