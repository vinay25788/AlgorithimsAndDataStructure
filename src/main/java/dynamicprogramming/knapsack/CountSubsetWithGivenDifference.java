package dynamicprogramming;

public class CountSubsetWithGivenDifference {
    public static void main(String[] args) {
        int[] a = {1,1,2,3};
        int diff = 1;
        System.out.println(countSubset(a,diff));
    }

    public static int countSubset(int[] a,int diff)
    {
        int sum =0;
        for(int i=0;i<a.length;i++)
            sum+= a[i];

        int s1 = (diff+sum)/2;

        return count(a,s1);
    }

    public static int count(int[] a,int sum)
    {
        int[][] t = new int[a.length+1][sum+1];

        for(int i=0;i<a.length+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0)
                    t[i][j] =0;
                if(j==0)
                    t[i][j] = 1;
            }
        }

        for(int i=1;i<a.length+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(a[i-1]<= j)
                    t[i][j] = t[i-1][j-a[i-1]] + t[i-1][j];
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[a.length][sum];
    }
}
