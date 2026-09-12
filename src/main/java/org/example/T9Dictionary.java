package org.example;

import java.util.*;

public class T9Dictionary {
    static final Map<Character,String> DIGTI_TO_LETTERS = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    private final int[] CHAR_TO_DIGIT = new int[26];
    private final Map<String, List<String>> digitsToWords = new HashMap<>();

    public T9Dictionary(List<String> words)
    {
        buildReverseMapping();
        buildIndex(words);
    }

    private void buildReverseMapping()
    {
        for(Map.Entry<Character,String> entry: DIGTI_TO_LETTERS.entrySet())
        {
            char digit = entry.getKey();
            for(char ch: entry.getValue().toCharArray())
            {
                CHAR_TO_DIGIT[ch-'a'] = digit-'0';
            }
        }
    }

    private void buildIndex(List<String> words)
    {
        for(String word: words)
        {
            String digit = encode(word);
            digitsToWords.computeIfAbsent(digit, k-> new ArrayList<>()).add(digit);
        }
    }

    private String encode(String word )
    {
        StringBuilder sb = new StringBuilder();
        for(char ch: word.toCharArray())
        {
            sb.append(CHAR_TO_DIGIT[ch-'a']);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> knownWords = Arrays.asList(
                "careers",
                "linkedin",
                "hiring",
                "interview",
                "linkedgo"
        );
        T9Dictionary dictionary =
                new T9Dictionary(knownWords);


        System.out.println(
                dictionary.findWords("2273377")
        );

        System.out.println(
                dictionary.findWords("54653346")
        );
    }
    public List<String> findWords(String phoneNumber) {

        return digitsToWords.getOrDefault(
                phoneNumber,
                Collections.emptyList()
        );
    }
}
