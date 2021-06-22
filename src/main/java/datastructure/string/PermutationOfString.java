package datastructure.string;

public class PermutationOfString {
    public static void main(String[] args) {
        String st = "abc";
        findPermute(st,"");
    }
    public static void findPermute(String st,String ans)
    {
        if(st.length() ==0)
        {
            System.out.println(ans);
            return;
        }
        for(int i=0;i<st.length();i++)
        {
            char ch = st.charAt(i);
            String leftSubString = st.substring(0,i);
            String rightSubstring = st.substring(i+1);
            String remaining = leftSubString+rightSubstring;
            findPermute(remaining,ans+ch);
        }
    }
}
