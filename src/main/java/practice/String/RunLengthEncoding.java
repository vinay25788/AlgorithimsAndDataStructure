package practice.String;

import java.util.Arrays;

public class RunLengthEncoding {
    public static void main(String[] args) {
        String str =  "aabcbcdaa";
        pre(str);
        random(str);
    }
    public static void pre(String str)
    {
        int count =0;
        for(int i=0;i<str.length();i++)
        {
            count =1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1))
            {
                count++;
                i++;
            }
            System.out.print(count+""+str.charAt(i));
        }

    }

    public static void random(String str)
    {
        int[] chars = new int[26];
        boolean[] visited = new boolean[26];
        int n = str.length();
        for(int i=0;i<n;i++)
        {
            chars[str.charAt(i)-'a']++;
        }

        System.out.println();
        for(int i=0;i<str.length();i++)
            if(str.charAt(i) !=0 && !visited[str.charAt(i)-'a'])
            {
                visited[str.charAt(i)-'a'] = true;
                System.out.print(chars[str.charAt(i)-'a']+""+str.charAt(i));
            }
    }
}
