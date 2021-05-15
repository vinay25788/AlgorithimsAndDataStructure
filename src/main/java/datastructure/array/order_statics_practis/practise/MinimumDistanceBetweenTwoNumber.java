package datastructure.array.order_statics_practis.practise;

public class MinimumDistanceBetweenTwoNumber {
    public static void main(String[] args) {
        int[] a = {1, 2,3, 3, 4, 5, 3, 2, 9};
        int first = 2;
        int second = 4;
        findDistance(a, first, second);
    }

    public static void findDistance(int[] a, int first, int second) {
        int minDistance = Integer.MAX_VALUE;
        int n = a.length;
        int prev = -1;
        for (int i = 0; i < n; i++) {
            int x = a[i];
            if(x == first || x == second)
            {
                if(prev != -1 && a[i] != a[prev])
                    minDistance = Math.min(minDistance,i - prev);
                prev = i;
            }
        }
        System.out.println(" mindistance "+minDistance);
    }
}
