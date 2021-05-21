package datastructure.matrix;

import java.util.Arrays;

public class RotateMatrixBy90 {
    public static void main(String[] args) {
        int mat[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int N = 4;
        rotateBy90(mat, N);
    }

    public static void rotateBy90(int[][] mat, int N) {

        for (int x = 0; x < N / 2; x++) {
            for (int y = x; y < N - 1 - x; y++) {
                int temp = mat[x][y];
                mat[x][y] = mat[y][N - 1 - x];
                mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];
                mat[N - 1 - y][x] = temp;
            }
        }

        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
                System.out.print(" "+mat[i][j]);
            System.out.println();
        }
    }
}
