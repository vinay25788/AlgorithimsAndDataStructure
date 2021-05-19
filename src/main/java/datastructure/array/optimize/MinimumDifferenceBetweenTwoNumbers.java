package datastructure.array.optimize;

public class MinimumDifferenceBetweenTwoNumbers {

    public static void main(String[] args) {
        int a[] = {3, 3, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
        int x = 2;
        int y = 0;
        System.out.println(findMinDiff(a, x, y));
    }

    public static int findMinDiff(int[] a, int x, int y) {
        int p = -1, minDist = Integer.MAX_VALUE;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == x || a[i] == y) {
                if (p != -1 && a[i] != a[p])
                    minDist = Math.min(minDist, i - p);
                p = i;
            }

        }

        return minDist;
    }
}
