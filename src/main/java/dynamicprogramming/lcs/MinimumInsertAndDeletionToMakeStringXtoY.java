package dynamicprogramming.lcs;

public class MinimumInsertAndDeletionToMakeStringXtoY {
    public static void main(String[] args) {
        String x = "heap", y = "pea";
        System.out.println(minOperation(x,y));
    }

    private static int minOperation(String x,String y)
    {
        int[][] t = new int[x.length()+1][y.length()+1];

        for(int i=1;i<x.length()+1;i++)
        {
            for(int j=1;j<y.length()+1;j++)
            {
                if(x.charAt(i-1) == y.charAt(j-1))
                    t[i][j] = 1+ t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
            }
        }

        int val = t[x.length()][y.length()];

        return (x.length()-val) + (y.length()-val);
    }
}
