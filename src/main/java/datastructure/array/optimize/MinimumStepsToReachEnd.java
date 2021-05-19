package datastructure.array.optimize;

public class MinimumStepsToReachEnd {

    public static void main(String[] args) {
        int a[] = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(findMinSteps(a));
    }

    public static int findMinSteps(int[] a) {
        int n = a.length;
        if (n <= 1)
            return 0;
        if (a[0] == 0)
            return 0;

        int maxReach = a[0];
        int steps = a[0];
        int jump = 1;
        for (int i = 1; i < n; i++) {
            if (i == n - 1)
                return jump;

            maxReach = Math.max(maxReach, i + a[i]);
            steps--;
            if (steps == 0)
            {
                jump++;
                if(i>=maxReach)
                    return -1;
                steps = maxReach-i;
            }
        }

        return -1;
    }
}
