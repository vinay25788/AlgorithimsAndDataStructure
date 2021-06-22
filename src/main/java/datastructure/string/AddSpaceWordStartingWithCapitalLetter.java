package datastructure.string;

public class AddSpaceWordStartingWithCapitalLetter {
    public static void main(String[] args) {
        String st ="HiThisIsVinay";
        addSpace(st);
    }
    public static void addSpace(String st)
    {
        char[] ch = st.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]>='A' && ch[i]<='Z')
            {
                if(i!=0)
                System.out.print(" ");
                System.out.print(ch[i]);
            }
            else
                System.out.print(ch[i]);
        }
    }
}
