package datastructure.array.order_statics_practis.practise;

public class FindMaxDifferenceJAndI {
    public static void main(String[] args) {
        int[] a = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        findMaxDiff(a);
    }

    public static void findMaxDiff(int[] a) {
        int i = 0, j = 0;
        int n = a.length;
        int[] lMin = new int[n];
        int[] rMax = new int[n];
        lMin[0] = a[0];
        for (i = 1; i < n; i++)
            lMin[i] = Math.min(a[i], lMin[i - 1]);
        rMax[n-1] = a[n-1];

        for(j=n-2;j>=0;j--)
            rMax[j] = Math.max(a[j],rMax[j+1]);
        i =0;
        j =0;
        int maxDiff = -1;

        while(i<n & j<n)
        {
            if(lMin[i]< rMax[j])
            {
                maxDiff = Math.max(maxDiff,j-i);
                j++;
            }
            else
                i++;
        }
        System.out.println("maxDiff "+maxDiff);
    }
}
