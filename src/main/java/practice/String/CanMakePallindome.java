package practice.String;

import java.util.ArrayList;
import java.util.List;

public class CanMakePallindome {
    public static void main(String[] args) {
        String st = "geeksogeeks";
        canGenerate(st);
    }
    private static void canGenerate(String st)
    {
        List<Character> list = new ArrayList<>();
        for(int i=0;i<st.length();i++)
        {
            if(list.contains(st.charAt(i)))
                list.remove((Character)st.charAt(i));
            else
                list.add(st.charAt(i));


        }
        if(st.length() %2 == 0 && list.isEmpty() || st.length() %2 !=0 && list.size() == 1)
            System.out.println("true");
        else
            System.out.println("no");

    }
}
