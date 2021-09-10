package practice.datastructure.array.sorting;

import java.util.Arrays;

public class MergeOneSizeToAnoterSizeMPlusN {
    public static void main(String[] args) {
        int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
        int N[] = {5, 7, 9, 25};
        int mn = mPlusN.length;
        int n = N.length;
        moveElementToEnd(mPlusN);
        merge(mPlusN, N, mn, n);
        System.out.println(Arrays.toString(mPlusN));
    }

    public static void merge(int[] mPlusN, int[] N, int mn, int n) {
        int i = n;
        int k = 0, j = 0;

        while (k < mn) {
            if ((i < mn && mPlusN[i] < N[j]) || j == n) {
                mPlusN[k++] = mPlusN[i];
                i++;
            } else {
                mPlusN[k++] = N[j];
                j++;
            }
        }

    }

    public static void moveElementToEnd(int[] mPlusN) {
        int mn = mPlusN.length, j = mn - 1;
        for (int i = mn - 1; i >= 0; i--) {
            if (mPlusN[i] > 0) {
                int temp = mPlusN[i];
                mPlusN[i] = mPlusN[j];
                mPlusN[j] = temp;
                j--;
            }
        }
    }
}
