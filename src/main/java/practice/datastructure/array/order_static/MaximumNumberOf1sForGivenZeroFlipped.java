package practice.datastructure.array.order_static;

public class MaximumNumberOf1sForGivenZeroFlipped {
    public static void main(String[] args) {
        int a[] = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        int m = 2;
        maximum(a, m);
    }

    public static void maximum(int[] a, int m) {
        int wl = 0, wr = 0, zeroCount = 0, bestL = 0, bestWindow = 0;

        while (wr < a.length) {
            if (zeroCount <= m) {
                if (a[wr] == 0) {
                    zeroCount++;
                }
                wr++;
            }

            if (zeroCount > m) {
                if(a[wl] ==0)
                zeroCount--;
                wl++;
            }

            if (wr - wl > bestWindow && zeroCount <= m) {
                bestWindow = wr - wl;
                bestL = wl;
            }
        }
        System.out.println(bestWindow);
        System.out.println(bestL);

        for (int i = 0; i < bestWindow; i++) {
            if (a[bestL + i] == 0)
                System.out.print((bestL + i) + " ");
        }
    }
}
