package datastructure.array.rotation;

public class FindMinimumElementInSortedRotatedArray {
    public static void main(String[] args) {
        // All input
        // {5, 6, 1, 2, 3, 4};
        //  {1, 2, 3, 4};
        //{5, 6, 7, 1, 2, 3, 4};
        //{2, 3, 4, 5, 6, 7, 8, 1};
        //{1,5,4,3,2}
        int[] a = {5, 6, 1, 2, 3, 4};
        System.out.println(findMinimum(a, 0, a.length - 1));
    }

    public static int findMinimum(int[] a, int low, int high) {
        if (high < low)
            return a[low];
        if (high == low)
            return a[low];
        int mid = (low + high) / 2;
        if (mid > low && mid < high && a[mid] < a[mid - 1] && a[mid] < a[mid + 1])
            return a[mid];
        
        if (a[high] > a[mid])
            return findMinimum(a, low, mid - 1);
        return findMinimum(a, mid + 1, high);
    }
}
