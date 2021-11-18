package datastructure.dynamicprograming.practise;

public class RodeCuttingProblem {
    public static void main(String[] args) {
        int[] a ={1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(maxProfit(a));
    }

    public static int maxProfit(int[] a)
    {
        int n = a.length;

        int[][] t = new int[n+1][n+1];
        int[] length = new int[n];
        for(int i=0;i<n;i++)
            length[i] = i+1;
        for(int i=1;i<a.length+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(j>=length[i-1])
                    t[i][j] = Math.max(t[i-1][j], a[i-1]+t[i][j-length[i-1]]);
                else
                    t[i][j] = t[i-1][j];
            }
        }

        return t[a.length][n];


    }

}
