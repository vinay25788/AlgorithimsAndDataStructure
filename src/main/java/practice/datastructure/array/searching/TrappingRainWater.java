package practice.datastructure.array.searching;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        collectWater(a);
    }

    public static void collectWater(int[] a) {
        int n = a.length;
        int lo = 0, hi = n - 1, leftMax = 0, rightMax = 0;
        int result = 0;

        while (lo < hi) {
            if (a[lo] < a[hi]) {
                if (leftMax < a[lo])
                    leftMax = a[lo];
                else
                    result += leftMax - a[lo];
                lo++;
            } else {
                if (a[hi] > rightMax)
                    rightMax = a[hi];
                else
                    result += rightMax - a[hi];
                hi--;
            }
        }
        System.out.println(result);
    }
}
