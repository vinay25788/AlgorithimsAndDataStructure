package datastructure.array.order_statics;

public class IndexMaxDifferenceForRightLargerAndLeftSmaller {
    public static void main(String[] args) {
        int a[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        findIndexMaxDiff(a);
    }

    public static void findIndexMaxDiff(int[] a) {
        int n = a.length;
        int[] l_min = new int[n];
        int[] r_max = new int[n];

        l_min[0] = a[0];
        for (int i = 1; i < n; i++)
            l_min[i] = Math.min(a[i], l_min[i - 1]);

        r_max[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; --i)
            r_max[i] = Math.max(a[i], r_max[i + 1]);
        int i = 0, j = 0;
        int max_diff = -1;
        while(i<n&& j<n)
        {
            if(l_min[i]<r_max[j])
            {
                max_diff = Math.max(max_diff,j-i);
                j++;
            }
            else
                i++;
        }
        System.out.println(max_diff);
    }
}
