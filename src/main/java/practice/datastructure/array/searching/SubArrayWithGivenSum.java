package practice.datastructure.array.searching;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] a = {1, 4, 0, 0, 3, 10, 5};
        int sum = 7;

        findSubArray(a, sum);
    }

    public static void findSubArray(int[] a, int sum) {
        int curSum = 0, start = 0, end = 0;

        int n = a.length;
        while (end < n) {
            while (curSum < sum && end < n) {
                curSum += a[end++];

            }
            if (curSum == sum) {
                System.out.println(start + " till " + --end );
                return;
            }
            while (curSum > sum && start < end) {
                curSum -= a[start++];
            }
        }
    }
}
