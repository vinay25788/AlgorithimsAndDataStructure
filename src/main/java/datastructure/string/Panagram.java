package datastructure.string;

/*
Panagram string which conain every letter of english alphabet
 */
public class Panagram {
    public static void main(String[] args) {
        String st = "The quick brown fox jumps over the lazy dog";;
        checkPanagram(st);
    }
    public static void checkPanagram(String st)
    {
        boolean[] check = new boolean[26];
        int n = st.length();
        int index = -1;
        for(int i=0;i<n ;i++)
        {
            if('A'<= st.charAt(i) && st.charAt(i) <= 'Z')
                index = st.charAt(i) - 'A';
            else if ('a' <= st.charAt(i) && st.charAt(i) <= 'z')
                index = st.charAt(i) - 'a';
            else
                continue;
            check[index] = true;
        }
        for(int i=0;i<26;i++)
            if(check[i] == false)
            {
                System.out.println("not panagram");
                return;
            }
        System.out.println("panagram");
    }

}
