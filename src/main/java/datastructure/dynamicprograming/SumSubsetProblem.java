package datastructure.dynamicprograming;

public class SumSubsetProblem {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 7};
        int sum = 20;
        find(a, sum);
    }

    public static void find(int[] a, int sum) {
        boolean[][] T = new boolean[a.length + 1][sum + 1];

        for(int i=0;i<=a.length;i++)
            T[i][0]=true;
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - a[i - 1] >= 0)
                    T[i][j] = T[i - 1][j] || T[i - 1][j - a[i - 1]];
                else
                    T[i][j] = T[i - 1][j];

            }
        }
        System.out.println(T[a.length][sum]);
    }
}