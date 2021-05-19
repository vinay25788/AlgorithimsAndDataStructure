package datastructure.array.order_statics;

public class MaximumSumCrossPathTwoArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 10, 15, 25};
        int[] b = { 4, 5, 6, 15, 20};
        findMaxSum(a, b);
    }

    public static void findMaxSum(int[] a, int[] b) {
        int sum1 = 0, sum2 = 0, i = 0, j = 0;
        int n = a.length, m = b.length;
        int result = 0;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                sum1 += a[i++];
            } else if (a[i] > b[j]) {
                sum2 += b[j++];
            } else {
                result += Math.max(sum1, sum2);
                sum1 = 0;
                sum2 = 0;
                int temp = i;
                while (i < n && a[i] == b[j])
                    sum1 += a[i++];
                while (j < m && b[j] == a[temp])
                    sum2 += b[j++];
                result += Math.max(sum1, sum2);
                sum1 = 0;
                sum2 = 0;

            }


        }
        while (i < n) {
            sum1 += a[i++];
        }
        while (j < m) {
            sum2 += b[j++];
        }
        result += Math.max(sum1, sum2);
        System.out.println("maximum sum --->" + result);
    }
}
