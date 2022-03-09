package dynamicprogramming.knapsack;

public class EqualSumPartition {

    public static void main(String[] args) {
        int[] a ={1,5,5,11,6};
        System.out.println(isPartitionPresent(a));
    }

    public static boolean isPartitionPresent(int[] a)
    {
        int sum = 0;
        for(int i=0;i<a.length;i++)
            sum +=a[i];
        if(sum % 2 !=0)
            return false;
        return checkPartition(a,sum/2,a.length);
    }

    public static boolean checkPartition(int[] a, int sum,int n)
    {
        boolean [][] t = new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0)
                    t[i][j] = false;
                if(j==0)
                    t[i] [j] = true;
            }
        }

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(a[i-1]<= j)
                {
                    t[i][j] = t[i-1][j-a[i-1]] || t[i-1][j];
                }
                else
                    t[i][j] = t[i-1][j];
            }
        }

        return t[n][sum];

    }
}
