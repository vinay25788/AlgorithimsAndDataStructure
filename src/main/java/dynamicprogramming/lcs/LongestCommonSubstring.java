package dynamicprogramming.lcs;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String x = "banana", y = "ananab";

        System.out.println(longestCommonSubstring(x,y));
    }

    private static int longestCommonSubstring(String x,String y)
    {
        int[][] t = new int[x.length()+1][y.length()+1];

        for(int i=1;i<x.length()+1;i++)
        {
            for(int j=1;j<y.length()+1;j++)
            {
                if(x.charAt(i-1) == y.charAt(j-1) && i!=j)
                    t[i] [j] = 1+t[i-1][j-1];
                else
                    t[i][j] =0;
            }
        }

        int max = Integer.MIN_VALUE;
       StringBuilder sb = new StringBuilder();
        for(int i=0;i<x.length()+1;i++)
        {
            for(int j=0;j<y.length()+1;j++)
            {
              max = Math.max(max,t[i][j]);
            }

        }

        return max;
    }
}
