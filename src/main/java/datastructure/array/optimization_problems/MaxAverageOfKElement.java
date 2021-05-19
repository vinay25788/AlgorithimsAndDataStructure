package datastructure.array.optimization_problems;

public class MaxAverageOfKElement {
    public static void main(String[] args) {
        int[] a = {1, 12, -5, -6, 50, 3};
        int k = 4;
        findAverage(a, k);
    }

    public static void findAverage(int[] a, int k) {
        int curSum = 0, maxSum = Integer.MIN_VALUE;
        int end = -1;

        for (int i = 0; i < k; i++)
            curSum += a[i];
        int n = a.length;
        maxSum = curSum; end = k-1;
        for (int i = k; i < n; i++) {
            curSum += a[i] - a[i - k];
            if (maxSum < curSum) {
                maxSum = curSum;
                end = i;
            }
        }
        System.out.println(maxSum);
        System.out.println(" maximum length subarray " + (end - k + 1));
    }
}
