package datastructure.array.order_statics;

public class FindMinimumDistanceBetweenTwoArrayElement {
    public static void main(String[] args) {
        int a[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
        int x = 3;
        int y = 6;
        minDistance(a, x, y);
    }

    public static void minDistance(int[] a, int x, int y) {
        int n = a.length;
        int i = 0, p = -1;
        int minDiff = Integer.MAX_VALUE;
        for (i = 0; i < n; i++) {
            if (a[i] == x || a[i] == y) {

                if (p != -1 && a[i] != a[p])
                    minDiff = Math.min(minDiff, i - p);
                p = i;
            }
        }
        System.out.println(minDiff);
    }
}
