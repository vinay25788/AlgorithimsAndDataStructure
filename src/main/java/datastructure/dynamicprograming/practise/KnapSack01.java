package datastructure.dynamicprograming.practise;

public class KnapSack01 {
    public static void main(String[] args) {
        int val[] = {10,15,40};
        int wt[] = {1,2,3};
        knapSack(val,wt,6);
    }
    public static void knapSack(int[] val,int[] wt,int w)
    {
        int[][] k = new int[val.length+1][w+1];
        for (int i = 0; i <= val.length; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    k[i][j] = 0;
                    continue;
                } else if (wt[i - 1] <= j) {
                    //  T[i][j] = Math.max(T[i-1][j], val[i-1]+T[i-1][j-wt[i-1]]);
                    k[i][j] = Math.max(k[i - 1][j], val[i - 1] + k[i - 1][j - wt[i - 1]]);
                } else
                    k[i][j] = k[i - 1][j];
            }
        }
        System.out.println(k[val.length][w]);
    }
}
