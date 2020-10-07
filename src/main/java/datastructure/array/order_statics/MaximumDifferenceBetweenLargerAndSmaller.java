package datastructure.array.order_statics;

public class MaximumDifferenceBetweenLargerAndSmaller {

    public static void main(String[] args) {
        int a[] = {1, 2, 90, 10, 110};
        findDiffer(a);
    }

    public static void findDiffer(int[] a) {
        int min_ele = a[0];
        int max_difference = a[0] - a[1];
        int n = a.length;
        int diff = 0;
        for (int i = 1; i < n; i++) {

            if (a[i] - min_ele > max_difference) {
                max_difference = a[i] - min_ele;
            }
            if (min_ele > a[i])
                min_ele = a[i];

        }
        System.out.println(max_difference);
    }
}
