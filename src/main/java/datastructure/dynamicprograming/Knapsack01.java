package datastructure.dynamicprograming;

public class Knapsack01 {

    public static int bottomUpDP(int[] val, int[] wt, int w) {
        int[][] k = new int[val.length + 1][w + 1];
        int res = 0;
        int result = 0;
        for (int i = 0; i <= val.length; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    k[i][j] = 0;
                    continue;
                } else if (wt[i - 1] <= j) {
                    k[i][j] = Math.max(k[i - 1][j], val[i - 1] + k[i - 1][j - wt[i - 1]]);
                } else
                    k[i][j] = k[i - 1][j];
            }
        }
        result = k[val.length][w];
        System.out.println(result);
        res = result;

        int col = w;
        for (int i = val.length; i > 0 && res > 0; i--) {
            if (res == k[i - 1][col])
                continue;
            else {
                System.out.print(wt[i - 1] + " ");
                res = res - val[i - 1];
                col = col - wt[i - 1];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Knapsack01 k = new Knapsack01();
        int val[] = {10, 15, 40};
        int wt[] = {1, 2, 3};
        int r = k.bottomUpDP(val, wt, 6);
        System.out.println(r);
    }
}
