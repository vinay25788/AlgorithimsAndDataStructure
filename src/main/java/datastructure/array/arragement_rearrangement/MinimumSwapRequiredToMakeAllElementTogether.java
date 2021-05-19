package datastructure.array.arragement_rearrangement;

public class MinimumSwapRequiredToMakeAllElementTogether {
    public static void main(String[] args) {
        int[] a = {2, 7, 9, 5, 8, 7, 4};
        int k = 5;
        System.out.println(findMinSwap(a, k));
    }

    public static int findMinSwap(int[] a, int k) {
        int count = 0;
        int n = a.length;
        for (int i = 0; i < n; i++)
            if (a[i] <= k)
                count++;

        int bad = 0;
        for(int i=0;i<count;i++)
            if(a[i]>k)
                bad++;

        int ans = bad;

        for(int i=0, j=count;j<n;++i,++j)
        {
            if(a[i] >k)
                --bad;
            if(a[j] >k)
                ++bad;
            ans = Math.min(ans,bad);
        }

        return ans;
    }
}
