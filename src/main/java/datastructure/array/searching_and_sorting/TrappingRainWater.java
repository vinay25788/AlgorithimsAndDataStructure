package datastructure.array.searching_and_sorting;

public class TrappingRainWater {
    public static void main(String[] args) {
        int a[] = {0, 1, 0, 2, 1, 0, 1,
                3, 2, 1, 2, 1};
        trappingRainWater(a);
    }

    public static void trappingRainWater(int[] a) {
        int n = a.length;
        int lo = 0, h = n - 1;
        int result = 0;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        while (lo <= h) {
            if (a[lo] < a[h]) {
                if (leftMax < a[lo])
                    leftMax = a[lo];
                else
                    result += leftMax - a[lo];
                lo++;
            } else {
                if (rightMax < a[h])
                    rightMax = a[h];
                else
                    result += rightMax - a[h];
                h--;
            }
        }
        System.out.println(" total trapped water is " + result);
    }
}
