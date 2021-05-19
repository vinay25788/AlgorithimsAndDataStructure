package datastructure.array.rotation.repeat_practise.rearrangement;

public class MaxProductInSubArray {
    public static void main(String[] args) {
        int[] a = {1, -2, -3, 0, 7, -8, -2};
        findProd(a);
    }

    public static void findProd(int[] a) {
        int max_so_far = 0;
        int max_ending_here = 1;
        int min_ending_here = 1;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                max_ending_here = max_ending_here * a[i];
                min_ending_here = Math.min(min_ending_here * a[i], 1);
            } else if (a[i] == 0) {
                max_ending_here = 1;
                min_ending_here = 1;
            } else {
                int temp = max_ending_here;
                max_ending_here = Math.max(min_ending_here * a[i], 1);
                min_ending_here = temp * a[i];
            }
            if (max_ending_here > max_so_far)
                max_so_far = max_ending_here;
        }
        System.out.println(max_so_far);

    }
}
