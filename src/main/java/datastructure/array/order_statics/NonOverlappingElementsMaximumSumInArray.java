package datastructure.array.order_statics;

public class NonOverlappingElementsMaximumSumInArray {
    public static void main(String[] args) {
        int a[] = {4, 1, 1, -1, -3, -5,
                6, 2, -6, -2};
        findSum(a);
    }

    public static void findSum(int[] a) {
        int max_so_far = 0, current_sum = 0;
        int n = a.length;
        int s = -1;
        int start = -1, end = -1;
        for (int i = 0; i < n; i++) {
            current_sum += a[i];
            if (max_so_far < current_sum) {
                max_so_far = current_sum;
                start = s;
                end = i;
            }
            if (current_sum < 0) {
                current_sum = 0;
                s = i + 1;
            }
        }

        System.out.println("maximum sum " + max_so_far + "  start index " + start + " ending index " + end);
    }
}
