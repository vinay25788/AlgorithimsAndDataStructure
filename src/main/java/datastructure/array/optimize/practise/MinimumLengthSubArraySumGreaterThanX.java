package datastructure.array.optimize.practise;

public class MinimumLengthSubArraySumGreaterThanX {
    public static void main(String[] args) {
        int a[] = {1, 4, 45, 6, 10, 19};
        int x = 51;
        System.out.println(findMin(a, x));
    }

    public static int findMin(int[] a, int x) {
        int n = a.length;
        int start = 0, end = 0, minLength = Integer.MAX_VALUE;
        int curSum = 0;
        while (end < n) {
            while (curSum <= x && end < n)
                curSum += a[end++];
            while (curSum > x && start < n) {
                if (minLength > end - start)
                    minLength = end - start;
                curSum -= a[start++];
            }
        }
        return minLength;
    }
}
