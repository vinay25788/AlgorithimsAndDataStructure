package datastructure.string;

public class FirstLetterWord {
    public static void main(String[] args) {
        String st = "hello this is vinay";
        firstLetter(st);
    }
    public static void firstLetter(String st)
    {
        char[] ch = st.toCharArray();
        int n = ch.length;
        for(int i=0;i<n;i++)
        {
            if(i==0)
                System.out.print(ch[i]);
            if(i<n-1 && ch[i] == ' ' && ch[i+1] !=' ')
                System.out.print(ch[i+1]);
        }
    }
}
