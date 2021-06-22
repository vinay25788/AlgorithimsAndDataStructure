package datastructure.string;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class MetaString {
    public static void main(String[] args) {
        String str1 = "converse";
        String str2 = "conserve";
        areMeta(str1,str2);
    }
    public static void areMeta(String s1,String s2)
    {
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 != l2)
        {
            System.out.println(" not possible ");
            return;
        }

        int prev = -1, cur = -1;
        int count =0;

        for(int i=0;i< l1;i++)
        {
            if(s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) {
                    System.out.println(" not possible ");
                    return;
                }
                prev = cur;
                cur = i;
            }
        }
        if( count == 2 && s1.charAt(prev) == s2.charAt(cur) && s1.charAt(cur) == s2.charAt(prev))
        {
            System.out.println(" possible ");
            return;
        }
    }
}
