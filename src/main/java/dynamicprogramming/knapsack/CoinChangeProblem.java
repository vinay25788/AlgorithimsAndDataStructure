package dynamicprogramming;

public class CoinChangeProblem {
    public static void main(String[] args) {
       int[] coins = {1, 2, 3};
       int sum = 4;
        System.out.println(countWays(coins,sum));
    }

    private static int countWays(int[] coins,int sum)
    {
        int[][] t = new int[coins.length+1][sum+1];
        for(int i=0;i<coins.length+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0)
                    t[i][j] =0;
                if(j==0)
                    t[i][j] = 1;

            }
        }

        for(int i=1;i<coins.length+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(coins[i-1]<= j)
                    t[i][j] = t[i-1][j]+t[i][j-coins[i-1]];
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[coins.length][sum];
    }
}
