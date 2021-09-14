package practice.String;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(lcs(s1,s2,s1.length(),s2.length()));
        System.out.println(lcs(s1,s2,s1.length(),s2.length()));
    }
    private static int lcs(String s1,String s2, int m,int n)
    {
        if(m==0 || n ==0)
            return 0;
        else if ( s1.charAt(m-1) == s2.charAt(n-1))
            return 1+ lcs(s1,s2,m-1,n-1);
        else
            return  Math.max(lcs(s1,s2,m,n-1),lcs(s1,s2,m-1,n));
    }

    private static int lcsUsingDp(String s1,String s2,int m,int n)
    {
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();

        int[][] T = new int[m+1][n+1];

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(x[i-1] == y[i-1])
                    T[i][j] = T[i-1][j-1]+1;
                else
                    T[i][j] = Math.max(T[i-1][j],T[i][j-1]);
            }
        }
        return T[m][n];

    }
}
