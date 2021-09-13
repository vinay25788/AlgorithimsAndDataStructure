package practice.String;

import java.util.HashSet;
import java.util.Set;

public class PermutationOfString {
   static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        String str = "ABC";
        permutation(str,"") ;
        System.out.println(set);
    }
    public static void permutation(String str,String ans)
    {
        if(str.isEmpty())
        {
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            String left = str.substring(0,i);
            String right = str.substring(i+1);
           String rest = left+right;
            permutation(rest,ans+ch);

        }
    }
}
