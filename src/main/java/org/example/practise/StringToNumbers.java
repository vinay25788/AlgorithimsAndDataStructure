package org.example.practise;

import org.example.T9Dictionary;

import javax.print.DocFlavor;
import java.sql.Array;
import java.util.*;

public class StringToNumbers {
    static Map<Character,String> map = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    static char[] CHAR_TO_DIGIT = new char[26];
    static Map<String, List<String>> digitToWords = new HashMap<>();

    StringToNumbers(List<String> words)
    {
        buildReverseMap();
        collectionWord(words);
    }

    private static void collectionWord(List<String> words)
    {

        for(String word: words)
        {
            String res = encode(word);
            digitToWords.computeIfAbsent(res, k->new ArrayList<>()).add(word);
        }

    }
    public static void main(String[] args) {


        buildReverseMap();

        List<String> knownWords = Arrays.asList(
                "careers",
                "linkedin",
                "hiring",
                "interview",
                "linkedgo"
        );

StringToNumbers obj = new StringToNumbers(knownWords);

        System.out.println(obj.findWords("2273377"));

    }

    private  List<String> findWords(String word)
    {

        return digitToWords.getOrDefault(word, Collections.emptyList());

    }

    private static String encode(String word)
    {
        StringBuilder sb = new StringBuilder();
        for(char ch: word.toCharArray())
        {
            sb.append(CHAR_TO_DIGIT[ch-'a']);
        }
        return sb.toString();
    }

    private static void buildReverseMap()
    {
        for(Map.Entry<Character,String> entry: map.entrySet())
        {
            char key = entry.getKey();
            for(char val: entry.getValue().toCharArray())
            {
                CHAR_TO_DIGIT[val-'a']= key;
            }
        }
    }




}
