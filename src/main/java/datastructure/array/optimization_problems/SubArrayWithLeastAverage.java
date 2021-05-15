package datastructure.array.optimization_problems;

public class SubArrayWithLeastAverage {
    public static void main(String[] args) {
        int[] a = {3, 7, 90, 20, 10, 50, 40};
        int k = 3;
        findMinAverage(a, k);
    }

    public static void findMinAverage(int[] a, int k) {
        if (a.length < k)
            return;
        int curSum = 0, resultIndex = 0, minSum = Integer.MAX_VALUE, n = a.length;

        for (int i = 0; i < k; i++)
            curSum += a[i];
        for (int i = k; i < n; i++) {
            curSum += a[i] - a[i - k];
            if (curSum < minSum)
            {
                minSum = curSum;
                resultIndex = i-k+1;
            }

        }
        System.out.println(" element from "+resultIndex+" index to "+(resultIndex+k-1)+" has minimum avaerage");
    }
}
