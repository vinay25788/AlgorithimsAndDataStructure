package datastructure.array.optimize;

public class LargestSumContinuousSubArray {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(" largest sum --->" + sum(a));
    }

    public static int sum(int[] a) {
        int max_so_far = 0;
        int max_ending_here = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
}
