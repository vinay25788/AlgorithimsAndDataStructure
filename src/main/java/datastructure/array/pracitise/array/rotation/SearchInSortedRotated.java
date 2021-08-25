package datastructure.array.pracitise.array.rotation;

public class SearchInSortedRotated {
    public static void main(String[] args) {
        int[] a = { 5, 1,2, 3,4};
        int x = 5;

        System.out.println(findIndex(a, x, 0, a.length - 1));
    }

    public static int findIndex(int[] a, int x, int l, int h) {
        if (h < l)
            return -1;
        int mid = (h + l) / 2;

        if (a[mid] == x)
            return mid;
        if (a[l] <= a[mid]) {
            if (x > a[l] && x < a[mid])
                return findIndex(a, x, l, mid - 1);
            return findIndex(a, x, mid + 1, h);
        }
        if (x >= a[mid] && x <= a[h])
            return findIndex(a, x, mid + 1, h);
        return findIndex(a, x, l, mid - 1);


    }
}
