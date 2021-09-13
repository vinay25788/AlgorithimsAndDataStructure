package practice.String;

import java.util.HashMap;
import java.util.Map;

public class MetaString {
    public static void main(String[] args) {
        System.out.println(isMetaWords("Converse","Conserve"));
    }
    static boolean isMetaWords(String firstWord, String secondWord) {
        if (firstWord.length() != secondWord.length()) {
            return false;
        }
        int firstDiff = -1, secondDiff = -1;
        Map<Character, Integer> wordStatistic = new HashMap<>();
        for (int i = 0; i < firstWord.length(); i++) {
            char symbol = firstWord.charAt(i);
            wordStatistic.put(symbol, wordStatistic.getOrDefault(symbol, 0) + 1);
            if (symbol != secondWord.charAt(i)) {
                if (firstDiff == -1) {
                    firstDiff = i;
                } else if (secondDiff == -1) {
                    secondDiff = i;
                } else {
                    return false;
                }
            }
        }
        if (firstDiff == -1 && secondDiff == -1) {
            // both strings are the same, just check that the string has repeatable symbols
            for (int v : wordStatistic.values()) {
                if (v > 1) {
                    return true;
                }
            }
            return false;
        }
        if (secondDiff == -1) {
            return false;
        }
        return firstWord.charAt(firstDiff) == secondWord.charAt(secondDiff)
                && firstWord.charAt(secondDiff) == secondWord.charAt(firstDiff);
    }
}
