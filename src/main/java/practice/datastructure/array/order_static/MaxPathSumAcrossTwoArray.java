package practice.datastructure.array.order_static;

public class MaxPathSumAcrossTwoArray {
    public static void main(String[] args) {
        int a[] = {2, 3, 7, 10, 12, 15, 30, 34};
        int b[] = {1, 5, 7, 8, 10, 15, 16, 19};
        maxPathSum(a, b);
    }

    public static void maxPathSum(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int result = 0, sum1 = 0, sum2 = 0;

        int i = 0, j = 0;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                sum1 += a[i];
                i++;
            } else if (a[i] > b[j]) {
                sum2 += b[j];
                j++;
            } else {
                result += Math.max(sum1, sum2) + a[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        while (i < n) {
            sum1 += a[i];
            i++;
        }
        while (j < m) {
            sum2 += b[j];
            j++;
        }
        result += Math.max(sum1, sum2);
        System.out.println(result);
    }
}
