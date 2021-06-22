package datastructure.string;

public class GenerateAllBinaryNumberFromGivenPattern {
    public static void main(String[] args) {
        String st = "1??0?101";
        int n = st.length();
        generate(st.toCharArray(),0);
    }
    public static void generate(char[] st,int index)
    {
        if(index == st.length)
        {
            System.out.println(st);
            return;
        }
        if(st[index]=='?')
        {
            st[index] = '1';
            generate(st,index+1);
            st[index] = '0';
            generate(st,index+1);
            st[index] ='?';
        }
        else
            generate(st,index+1);


    }
}
