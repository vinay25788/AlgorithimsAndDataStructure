package datastructure.string;

import java.util.ArrayList;
import java.util.List;

public class MissingCharacterToMakePanagram {
    public static void main(String[] args) {
        String st = "The quick brown fox jumps oer the lazy dog";
        List<Character> list = new ArrayList<>();
        findMissingCharacter(st,list);
        for(Character ch : list)
            System.out.print(ch +" ");
    }
    public static void findMissingCharacter(String st, List<Character> list)
    {
        boolean [] check = new boolean[26];
        int n = st.length();
        int index = -1;
        for(int i=0;i<n;i++)
        {
            if('A' <= st.charAt(i) && st.charAt(i)<='Z')
                index = st.charAt(i) - 'A';
            else if ( 'a' <= st.charAt(i) && st.charAt(i) <= 'z')
                index = st.charAt(i)- 'a';
            else
                continue;
            check[index]= true;
        }
        for(int i=0;i<26;i++)
            if(!check[i])
                list.add((char)(i+'a'));
    }
}
