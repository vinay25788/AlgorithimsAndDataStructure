package practice.String;

public class CombineFirstLetter {
    public static void main(String[] args) {
        String st ="Vinay Kumar sharma garg";
        concatenateFirstLetter(st);
    }

    private static void concatenateFirstLetter(String st)
    {
        int n = st.length();
        boolean v = true;
        String res = "";
     //   res +=st.charAt(0);
        for(int i=0;i<n;i++)
        {
            if(st.charAt(i) == ' ')
            {
                v = true;
            }
            else if ( st.charAt(i) != ' ' && v)
            {
                res +=st.charAt(i)+"";
                v = false;
            }
        }
        System.out.println(res);
    }



}
