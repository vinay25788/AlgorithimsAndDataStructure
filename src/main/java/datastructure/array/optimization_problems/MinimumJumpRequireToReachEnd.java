package datastructure.array.optimization_problems;

public class MinimumJumpRequireToReachEnd {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        findMinimumJup(a);
    }

    public static void findMinimumJup(int[] a) {
        int n = a.length;

        if (n <= 1) {
            System.out.println("minimum steps 0");
            return;
        }

        if (a[0] == 0) {
            System.out.println(" not possible to take jump ");
            return;
        }

        int maxReach = a[0];
        int steps = a[0];
        int jump = 1;
        for (int i = 1; i < n; i++) {
            if (i == n-1) {
                System.out.println(" maximum jump " + jump);
                return;
            }
            maxReach = Math.max(maxReach, i + a[i]);
            steps--;
            if (steps == 0) {
                jump++;
                if (i >= maxReach) {
                    System.out.println(" not able to reach till end ");
                    return;
                }

                steps = maxReach - i;
            }
        }
    }
}
