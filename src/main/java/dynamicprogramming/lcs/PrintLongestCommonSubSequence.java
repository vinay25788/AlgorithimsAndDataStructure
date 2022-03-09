package dynamicprogramming.lcs;

public class PrintLongestCommonSubSequence {
    public static void main(String[] args) {
        String x = "abcdda";
        String y = "zbca";
        printLCS(x,y);
    }

    private static void printLCS(String x,String y)
    {
        int[][] t = new int[x.length()+1][y.length()+1];

        for(int i=0;i<x.length()+1;i++)
        {
            for(int j=0;j<y.length()+1;j++) {
                if (i == 0)
                    t[i][j] = 0;
                if (j == 0)
                    t[i][j] =0;
            }
        }

        for(int i=1;i<x.length()+1;i++)
        {
            for(int j=1;j<y.length()+1;j++)
            {
                if(x.charAt(i-1) == y.charAt(j-1))
                    t[i][j] = 1+t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }

        int i= x.length(), j=y.length();
        StringBuilder sb = new StringBuilder();

        while(i>0 && j>0)
        {
            if(x.charAt(i-1) == y.charAt(j-1))
            {
                sb.append(x.charAt(i-1));
                i--;
                j--;
            }
            else
            {
                if(t[i][j-1]> t[i-1][j])
                    j--;
                else
                    i--;

            }
        }
        System.out.println(sb.reverse());
    }
}
