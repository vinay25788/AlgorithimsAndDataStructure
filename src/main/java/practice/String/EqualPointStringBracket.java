package practice.String;

public class EqualPointStringBracket {
    public static void main(String[] args) {
        String st = "(()))(()()())))";
        check(st);
    }
    private static void check(String st)
    {
        int n = st.length();
        int[] open = new int[n+1];
        int[] close = new int[n+1] ;

        open[0] = 0;
        close[n] = 0;

       if(st.charAt(0) == '(')
           open[1] =1;
       if(st.charAt(n-1) == ')')
           close[n-1] = 1;

       for(int i=1;i<n;i++)
       {
           if(st.charAt(i) == '(')
               open[i+1] = open[i]+1;
           else
               open[i+1] = open[i];
       }

       for(int i=n-2;i>=0;i--)
       {
           if(st.charAt(i) == ')')
               close[i] = close[i+1]+1;
           else
               close[i] = close[i+1];
       }

       if(open[n] == 0)
       {
           System.out.println(" zero ");
           return;
       }
       if(close[0] == 0)
       {
           System.out.println(" zero close ");
           return;
       }

       for(int i=1;i<=n;i++)
           if(open[i] == close[i])
           {
               System.out.println(i);

           }

    }
}
