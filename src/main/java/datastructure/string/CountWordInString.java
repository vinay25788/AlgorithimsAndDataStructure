package datastructure.string;

public class CountWordInString {
    public static void main(String[] args) {
        String st = "One two       three\n four\tfive ";
        countWords(st);
    }
    public static void countWords(String st)
    {
        if(st == null || st.isEmpty())
        {
            System.out.println("Empty string");
            return;
        }
        int words =0;
        boolean isWord = false;
        int n = st.length()-1;
        char[] ch = st.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if(Character.isLetter(ch[i]) && i != n)
                isWord= true;
            else if ( !Character.isLetter(ch[i]) && isWord)
            {
                words++;
                isWord = false;
            }
            else if(Character.isLetter(ch[i]) && i == n)
                words++;
        }
        System.out.println(words);
    }
}
