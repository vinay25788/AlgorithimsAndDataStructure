package practice.datastructure.array.optimization;

public class SubArrayWithLeastAverage {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 6, 3, 10};
        int k = 3;
        findLeastAVerage(a, k);
    }

    public static void findLeastAVerage(int[] a, int k) {
        int curSum = 0;
        int resIndex = -1;
        for (int i = 0; i < k; i++)
            curSum += a[i];

        int minSum = Integer.MAX_VALUE;
        for (int i = k; i < a.length; i++) {
            curSum += a[i] - a[i - k];
            if(minSum>curSum)
            {
                minSum = curSum;
                resIndex = i-k+1;
            }
        }
        System.out.println(resIndex+" "+(resIndex+k-1));

    }
}
