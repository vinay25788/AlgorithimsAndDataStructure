package datastructure.array.optimization_problems;

public class LargestSumContinuousArray {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        findLargestSum(a);
    }

    public static void findLargestSum(int[] a) {
        int max_ending_here = 0, max_so_far = Integer.MIN_VALUE;
        int start = -1, end = -1, n = a.length;
        int s = 0;
        for (int i = 0; i < n; i++) {
            max_ending_here += a[i];
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }
            if (max_ending_here < 0)
            {
                s = i+1;
                max_ending_here = 0;
            }
        }
        System.out.println(" maximum "+max_so_far+" start "+start+" end "+end);
    }
}
