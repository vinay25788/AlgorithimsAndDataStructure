package practice.algorithim.dynamincprogramming;

public class DecodingNumberForAlphabet {
    public static void main(String[] args) {
        String st = "12312";
        System.out.println(decode(st.toCharArray(), st.length()));

        System.out.println(countDecode(st.toCharArray(),st.length()));
    }

    public static int decode(char[] st, int n) {
       int[] count = new int[n+1];
       count[0] = 1;
       count[1] = 1;
        for(int i=2;i<=n;i++)
       {
           if(st[i-1] >'0')
               count[i] = count[i-1];
           if(st[i-2] == '1' || (st[i-2] == '2' && st[i-1] <'7' ))
               count[i] += count[i-2];
       }
       return count[n];
    }

    public static int countDecode(char[] a,int n)
    {
        if(a[0] == 0)
            return 0;
        if(n == 0 || n==1 )
            return 1;

        int count =0;
        if( a[n-1]>'0')
            count += decode(a, n-1);
        if(a[n-2] == '1' || (a[n-2] == '2' && a[n-1] == '1'))
            count += decode(a,n-2);
        return count;
    }

}
