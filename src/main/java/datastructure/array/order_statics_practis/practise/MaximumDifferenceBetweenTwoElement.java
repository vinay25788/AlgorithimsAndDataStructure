package datastructure.array.order_statics_practis.practise;

public class MaximumDifferenceBetweenTwoElement {
    public static void main(String[] args) {
        int[] a = {1, 2, 90, 10, 110};
        findDiff(a);
    }

    public static void findDiff(int[] a) {
        int n = a.length;
        int maxRight = a[n - 1];
        int maxDiff = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > maxRight)
                maxRight = a[i];
            else {
                int currDiff = maxRight - a[i];
                if (currDiff > maxDiff)
                    maxDiff = currDiff;
            }

        }
        System.out.println(maxDiff);
    }
}
