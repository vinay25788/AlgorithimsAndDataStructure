package datastructure.string;

public class StringInSortedOrderFollowedBySum {
    public static void main(String[] args) {
        String st ="AC2FB3";
        sortString(st);
    }
    public static void sortString(String st)
    {
        int[] charCount = new int[26];
        int sum = 0;
        for(int i=0;i<st.length();i++)
        {
            if(Character.isUpperCase(st.charAt(i)))
                charCount[st.charAt(i)-'A']++;
            else
                sum +=st.charAt(i)-'0';
        }
        String res ="";
        for(int i=0;i<26;i++)
        {
            if(charCount[i] !=0)
                res+=(char)(i+'A');

        }
        if(sum >0)
            res+=sum;
        System.out.println(res);
    }

}
