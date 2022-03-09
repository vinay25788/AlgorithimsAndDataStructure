package dynamicprogramming.knapsack;

public class UnboundedKnapSack {
    public static void main(String[] args) {
        int W = 100;
        int val[] = {10, 30, 20};
        int wt[] = {5, 10, 15};

        System.out.println(maxProfit(wt,val,W,val.length));
        System.out.println(usingDP(wt,val,W));
    }

    public static int maxProfit(int[] wt,int[] val,int W,int n)
    {
        if(n ==0 || W ==0)
            return 0;

        if(wt[n-1]<=W)
            return Math.max(val[n-1] + maxProfit(wt,val,W-wt[n-1],n), maxProfit(wt,val,W,n-1));
         else
            return maxProfit(wt,val,W,n-1);

    }

    public static int usingDP(int[] wt,int[] val,int W)
    {
        int[][] t = new int[val.length+1][W+1];

        for(int i=0;i<val.length+1;i++)
        {
            for(int j=0;j<W+1;j++)
            {
                if(i==0)
                    t[i][j] = 0;
                if(j==0)
                    t[i][j] =0;
             }
        }

        for(int i=1;i<val.length+1;i++)
        {
            for(int j=1;j<W+1;j++)
            {
                if(wt[i-1]<=j)
                    t[i][j] = Math.max(val[i-1]+t[i][j-wt[i-1]] , t[i-1][j]);
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[val.length][W];
    }
}
