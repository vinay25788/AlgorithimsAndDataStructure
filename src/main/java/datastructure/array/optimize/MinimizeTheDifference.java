package datastructure.array.optimize;

import java.util.Arrays;

public class MinimizeTheDifference {
    public static void main(String[] args) {
        int[] a = {4,6};
        int k = 10;
        System.out.println(findDiff(a, k));
    }

    public static int findDiff(int[] a, int k) {
        int n = a.length;
        if (n == 1)
            return 0;
        Arrays.sort(a);

        int ans = a[n-1]-a[0];
        int small = a[0] + k;
        int big = a[n - 1] - k;
        if(small>big)
        {
            int temp = small;
            small = big;
            big = temp;
        }
        for(int i=1;i<n-1;i++)
        {
            int subtract = a[i]-k;
            int add = a[i]+k;
            if(subtract>= small && add <= big)
                continue;
            if(big - subtract <= add - small)
                small = subtract;
            else
                big = add;
        }
        return Math.min(ans,big-small);
    }
}
