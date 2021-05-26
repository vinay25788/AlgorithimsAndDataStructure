package algorithims.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapRequired {
    public static void main(String[] args) {
        int[] a = {2, 5, 3, 4};
        countSwap(a);
    }

    public static void countSwap(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            map.put(a[i], i);
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            a[i] = map.get(a[i]);
        }
        int countSwap = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < 0)
                continue;
            ;
            int val = a[i];
            while (val != i) {
                int newValue = a[val];
                a[val] = -1;
                val = newValue;
                countSwap++;
            }
            a[i] = -1;
        }
        System.out.println(" swap required " + countSwap);
    }
}
