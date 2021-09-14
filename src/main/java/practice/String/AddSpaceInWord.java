package practice.String;

public class AddSpaceInWord {
    public static void main(String[] args) {
        String st = "VinayKumar";
        addSpace(st);
    }
    private static void addSpace(String st)
    {
        char[] ch = st.toCharArray();
        int n = st.length();
        for(int i=0;i<n;i++)
        {
            if(st.charAt(i) >= 'A' && st.charAt(i) <= 'Z')
            {
                ch[i] = (char) (ch[i] + 32);
                System.out.print(" ");
                System.out.print(ch[i]);
            }
            else
                System.out.print(st.charAt(i));
        }
    }
}
