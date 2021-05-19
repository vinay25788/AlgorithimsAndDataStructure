package datastructure.array.sort.practise_sorting_programs;

public class MinimumSwapToSortAnArray {
    public static void main(String[] args) {
        int[] a = {1, 20, 6, 4, 5};
        System.out.println("Minimum number of swap " + countSwap(a, 0, a.length - 1));
    }

    public static int countSwap(int[] a, int l, int r) {
       int count = 0,m;
        if (r>l) {
             m = l + (r - l) / 2;
             count = countSwap(a, l, m);
             count+= countSwap(a, m + 1, r);
            count += mergeCount(a, l, m+1, r);
        }
        return count;
    }

    public static int mergeCount(int[] a, int l, int m, int r) {

        int i = l, j = m , k = l;
        int[] b = new int[a.length];
        int swaps = 0;
        while (i <= m-1 && j <= r) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
                swaps += m - i;
            }
        }
        while (i <= m-1)
            b[k++] = a[i++];
        while (j <= r)
            b[k++] = a[j++];

        for (i = l; i <= r; i++)
            a[i] = b[i];

        return swaps;
    }
}
