package datastructure.array.order_statics_practis.practise;

public class MinimumDistanceBetweenTwoArrayElement {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 1, 2, 5, 4};
        int first = 2;
        int second = 4;
        findDistance(a, first, second);
    }

    public static void findDistance(int[] a, int first, int second) {
        int minDistance = Integer.MAX_VALUE;
        int prev = -1, n = a.length;
        for (int i = 0; i < n; i++) {
            int x = a[i];
            if (x == first || x == second) {
                if (prev != -1 && a[i] != a[prev])
                    minDistance = Math.min(minDistance, i - prev);
                    prev = i;


            }
        }
        System.out.println("MinDistance   " + minDistance);
    }
}
