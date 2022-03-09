package dynamicprogramming.knapsack;

public class CountSumPartition {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3};
        int x = 6;
        System.out.println(count(a,x));
    }

    public static int count(int[] a,int sum)
    {
        int[][] t = new int[a.length+1][sum+1];

        for(int i=0;i<a.length+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0)
                    t[i][j] = 0;
                if(j==0)
                    t[i][j] =1;
            }
        }

        for(int i=1;i<a.length+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(a[i-1]<= j)
                {
                    t[i][j] = t[i-1][j-a[i-1]] + t[i-1][j];
                }
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[a.length][sum];
    }
}
