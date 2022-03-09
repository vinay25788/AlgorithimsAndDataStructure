package dynamicprogramming.mcm;

public class MatrixChainMultiplicationBottomUp {

   static int[][] t;
    public static void main(String[] args) {
        int[] a = {40, 20, 30, 10, 30};
        t = new int[a.length+1][a.length+1];
        for(int i=0;i<a.length+1;i++)
            for(int j=0;j<a.length+1;j++)
                t[i][j] = -1;
        System.out.println(mcm(a,1,a.length-1));
    }

    private static int mcm(int[] a,int i,int j)
    {
        if(i>=j)
            return 0;
        if(t[i][j] != -1)
            return t[i][j];
        int min = Integer.MAX_VALUE;

        for(int k=i;k<j;k++)
        {
            int tempAns = mcm(a,i,k)+mcm(a,k+1,j)+a[i-1]*a[k]*a[j];
            if(min>tempAns)
                min = tempAns;
        }

        return t[i][j] = min;
    }
}
