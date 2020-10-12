package datastructure.array.order_statics.practice;

public class FindZeroFlippedToGetMaximum1s {
    public static void main(String[] args) {
        int a[] = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        int n = 2;
        find(a, n);
    }

    public static void find(int[] a, int n) {
        int wR = 0, wL = 0, zeroCount = 0, bestW = 0;
        int bestL = 0;
        int len = a.length;
        while (wR < len) {
            if (zeroCount <= n) {
                if (a[wR] == 0)
                    zeroCount++;
                wR++;
            }
            if (zeroCount > n) {
                if (a[wL] == 0)
                    zeroCount--;
                wL++;
            }

            if (wR - wL > bestW && zeroCount <= n) {
                bestW = wR - wL;
                bestL = wL;
            }
        }

        for (int i = 0; i < bestW; i++)
            if (a[bestL + i] == 0)
                System.out.println(bestL + i + " ");
    }
}
