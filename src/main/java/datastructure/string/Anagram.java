package datastructure.string;

public class Anagram {
    public static void main(String[] args) {
        char str1[] = "geeksforgeeks".toCharArray();
        char str2[] = "forgeeksgeeksm".toCharArray();
        System.out.println(AreAnagram(str1,str2));
    }
    public static boolean AreAnagram(char[] st1,char[] st2)
    {
        if(st1.length != st2.length)
            return false;
        int[] charCount = new int[26];
        for(int i=0;i<st1.length;i++)
        {
            charCount[st1[i]-'a']++;
            charCount[st1[i]-'a']--;
        }
        for(int i=0;i<26;i++)
            if(charCount[i]>0)
                return false;
            return true;
    }
}
