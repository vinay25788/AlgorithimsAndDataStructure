package datastructure.string;

import java.util.Arrays;

public class ReverseWord {
    public static void main(String[] args) {
        String s1 = "my name is vinay kumar";
                String[] words = s1.split("\\s");
        System.out.println(reverse(words));
    }
    public static String reverse(String[] words)
    {
        int l = words.length;
        if(l %2 ==0)
        {
            int j = l/2;
            while(j<l)
            {
                String temp = words[l-j-1];
                words[l-j-1] = words[j];
                words[j] = temp;
                j++;
            }
        }
        else
        {
            int j = (l/2)+1;
            while(j<l)
            {
                String temp = words[l-j-1];
                words[l-j-1] = words[j];
                words[j] = temp;
                j++;
            }
        }
        return String.join(" ",words);
    }
}
