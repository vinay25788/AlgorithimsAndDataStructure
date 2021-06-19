package datastructure.string;

import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionary {
    public static void main(String[] args) {
        String[] s = {"ale", "apple", "monkey", "plea"};
        List<String> list = Arrays.asList(s);
        String s2 = "abpcplea";
        findLongestWord(list,s2);
    }
    public static void findLongestWord(List<String> list,String s2)
    {
        String result="";
        int maxLength = 0;
        for(String word:list)
        {
            if(maxLength<word.length() && isSubSequnce(word,s2))
            {
                maxLength = word.length();
                result = word;
            }
        }
        System.out.println(result);
    }
    public static boolean isSubSequnce(String s1,String s2)
    {
        int m = s1.length();
        int n = s2.length();
        int j=0;
        for(int i =0; j<m && i<n ;i++)
            if(s1.charAt(j) == s2.charAt(i))
                j++;

            return j==m;
    }
}
