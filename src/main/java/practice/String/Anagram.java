package practice.String;

public class Anagram {
    public static void main(String[] args) {
        String st1= "triangle";
        String st2 = "integral";
        check(st1,st2);
    }
    private static void check(String st1,String st2)
    {
        int count[] = new int[26];
        if(st1.length() != st2.length())
        {
            System.out.println("not anagram");
            return;
        }
        for(int i=0;i<st1.length();i++)
        {
            count[st1.charAt(i)-'a'] ++;
            count[st2.charAt(i) - 'a']--;
        }

        for(int i=0;i<st1.length();i++)
            if(count[st1.charAt(i)-'a'] !=0)
            {
                System.out.println(" not anagram ");
                return;
            }
        else
            {
                System.out.println("anagram");
                return;
            }
    }
}
