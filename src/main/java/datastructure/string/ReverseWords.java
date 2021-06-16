package datastructure.string;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ReverseWords {
    public static void main(String[] args) {
        String st = "I love java programming";
        String [] words = st.split(" ");
        Pattern pat = Pattern.compile("\\s");
        String[] ws = pat.split(st);

        String res="";
        int n = ws.length;
        for(int i=0;i<n;i++)
        {
            if(i == n-1)
                res = ws[i]+ res;
            else
                res = " "+ ws[i]+ res;
        }
        System.out.println(res);
    }
}
