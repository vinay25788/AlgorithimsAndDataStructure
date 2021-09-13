package practice.algorithim.dynamincprogramming;

import java.util.Arrays;

public class WildCardPatternMatching {
    public static void main(String[] args) {
        String str = "xaylmz";
        String pat = "x?y*z";
        isMatched(str, pat);
    }

    public static void isMatched(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();


       // int writeIndex = 0;
        //replace multiple * with one *
        //e.g a**b***c --> a*b*c
        int writeIndex = 0;
        boolean isFirst = true;
        for ( int i = 0 ; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }


        boolean T[][] = new boolean[str.length + 1][writeIndex + 1];

        if (writeIndex > 0 && pattern[0] == '*') {
            T[0][1] = true;
        }

        T[0][0] = true;


        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '?' || pattern[j - 1] == str[i - 1])
                    T[i][j] = T[i - 1][j - 1];
                else if (pattern[j - 1] == '*')
                    T[i][j] = T[i - 1][j] || T[i][j - 1];
            }
        }

        /*
         for (int i = 1; i < T.length; i++) {
            for (j = 1; j < T[0].length; j++) {
                if (patt[j - 1] == '?' || patt[j - 1] == text[i - 1])
                    T[i][j] = T[i - 1][j - 1];
                else if (patt[j - 1] == '*')
                    T[i][j] = T[i - 1][j] || T[i][j - 1];
            }
        }
         */
        System.out.println( T[s.length()][writeIndex]);
       /* char[] text = str.toCharArray();
        char[] patt = pat.toCharArray();
        boolean isFirst = true;
        int writeIndex = 0;

        int j = 0;
        for (int i = 0; i < patt.length; i++) {
            if (patt[i] == '*') {
                if (isFirst) {
                    patt[writeIndex++] = patt[i];
                    isFirst = false;
                }
            } else {
                patt[writeIndex++] = patt[i];
                isFirst = true;
            }
        }

        System.out.println("writeIndex "+writeIndex+" text length "+text.length);

        boolean T[][] = new boolean[text.length + 1][writeIndex + 1];
        if (writeIndex > 0 && patt[0] == '*')
            T[0][1] = true;

        T[0][0] = false;

        System.out.println("   T[0][1]   "+ T[0][1]);

        for (int i = 1; i < T.length; i++) {
            for (j = 1; j < T[0].length; j++) {
                if (patt[j - 1] == '?' || patt[j - 1] == text[i - 1])
                    T[i][j] = T[i - 1][j - 1];
                else if (patt[j - 1] == '*')
                    T[i][j] = T[i - 1][j] || T[i][j - 1];
            }
        }
        System.out.println(T[text.length][writeIndex]);*/
    }
}
