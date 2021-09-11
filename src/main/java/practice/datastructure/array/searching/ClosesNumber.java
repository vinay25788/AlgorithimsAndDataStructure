package practice.datastructure.array.searching;

import java.util.Arrays;

public class ClosesNumber {
    public static void main(String[] args) {
        int[] a = {5, 3, 2, 4, 1,9,56};
        closestNumber(a);
    }

    public static void closestNumber(int[] a) {
        int minDif = Integer.MAX_VALUE;
        Arrays.sort(a);
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int diff = a[i] - a[i - 1];
            if (diff < minDif)
                minDif = diff;

        }
        for(int i=1;i<n;i++)
            if(a[i]-a[i-1]== minDif)
                System.out.println(a[i]+" "+a[i-1]);
    }
}
