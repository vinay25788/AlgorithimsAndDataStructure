package datastructure.dynamicprograming;

public class MatricChainMultiplication {
    public static void main(String[] args) {
        int[] a= {1,2,3,4};
        System.out.println(calculate(a));
    }
    public static int calculate(int[] a)
    {
        int n = a.length;
        int[][] T = new int[n][n];


        for(int l=2;l<n;l++)
        {
            for(int i=0;i<n-l;i++)
            {
                int j = i+l;
                 T[i][j] = Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++)
                {
                     int min = T[i][k]   +T[k][j]+ a[i]*a[j]*a[k];

                    if(T[i][j]>min)
                        T[i][j] = min;
                }
            }

        }
        return T[0][n-1];
    }
}
