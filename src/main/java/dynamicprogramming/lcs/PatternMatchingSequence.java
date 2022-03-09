package dynamicprogramming.lcs;

public class PatternMatchingSequence {
    public static void main(String[] args) {
        String x = "abc";
        String y = "adkbgdc";
        System.out.println(lcs(x,y));
    }

    private static boolean lcs(String x,String y)
    {
        int[][] t = new int [x.length()+1][y.length()+1];

        for(int i=1;i<x.length()+1;i++)
        {
            for(int j=1;j<y.length()+1;j++)
            {
                if(x.charAt(i-1) == y.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
            }
        }

        int val = t[x.length()][y.length()];

        if(val == x.length())
            return true;
        else
            return false;
    }
}
