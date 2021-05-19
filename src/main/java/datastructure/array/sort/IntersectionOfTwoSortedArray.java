package datastructure.array.sort;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArray {
    public static void main(String[] args) {
        int[] a = {2, 3, 5, 7, 7, 9};
        int[] b = {3, 7, 7, 9};
        findIntersection(a, b);

    }

    public static void findIntersection(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        //List is used to handle duplicate
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                if (!list.contains(a[i]))
                {
                    list.add(a[i]);
                    System.out.print(" " + a[i]);
                }
                    i++;
                j++;
            }
        }
    }
}
