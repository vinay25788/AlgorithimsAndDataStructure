package datastructure.array.sort.practise_sorting_programs;

import java.util.Arrays;

public class MergeKArray {
    public static void main(String[] args) {
        int a[][] = {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};
        int k = a.length;
        int output[] = new int[a[0].length * k];
        mergeKArray(a, 0, 2, output);
        System.out.println(Arrays.toString(output));
    }

    public static void mergeKArray(int[][] a, int i, int j, int[] output) {
        if (i == j) {
            for (int p = 0; p < a[0].length; p++)
                output[p] = a[i][p];
            return;
        }
        if (j - i == 1) {
            mergeArray(a[i], a[j], a[0].length, a[0].length, output);
            return;
        }
        int[] output1 = new int[a[0].length * (((i + j) / 2) - i + 1)];
        int[] output2 = new int[a[0].length * (j - ((i + j) / 2))];
        mergeKArray(a, i, (i + j) / 2, output1);
        mergeKArray(a, (i + j) / 2 + 1, j, output2);
        mergeArray(output1, output2, a[0].length * ((i + j) / 2 - i + 1), (a[0].length * (j - (i + j) / 2)), output);
    }

    public static void mergeArray(int[] a, int[] b, int n1, int n2, int[] output) {
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (a[i] < b[j])
                output[k++] = a[i++];
            else
                output[k++] = b[j++];
        }
        while (i < n1)
            output[k++] = a[i++];
        while (j < n2)
            output[k++] = b[j++];
    }
}

















