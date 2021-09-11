package practice.datastructure.array.searching;

import java.util.Arrays;

public class RepeatedSearch {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        search(a,1);
    }
    public static void search(int[] a,int x)
    {
        Arrays.sort(a);
        int n = a.length, max = a[n-1];
        for(int i=0;i<n;i++) {
            if (x < max) {
                if (Arrays.binarySearch(a, x) != -1)
                    x = 2 * x;
                else {
                    System.out.println(x);
                    break;
                }
            }
        }
        System.out.println(x);
    }
}
