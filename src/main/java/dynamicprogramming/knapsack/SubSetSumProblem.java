package dynamicprogramming.knapsack;

public class SubSetSumProblem {


    public static void main(String[] args) {
        int[] arr = {2,3,8};
        int sum = 14;
        System.out.println(subsetSum(arr,sum));

    }


    static public boolean subsetSum(int[] arr,int sum)
    {
        boolean[][] t = new boolean[arr.length+1][sum+1];

        for(int i=0;i<arr.length+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0)
                    t[i][j] = false;
                if(j==0)
                    t[i][j] = true;
            }
        }

        for(int i=1;i< arr.length+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(arr[i-1]<= j)
                {
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[arr.length][sum];
    }
}
