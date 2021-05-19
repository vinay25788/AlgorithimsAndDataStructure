package datastructure.array.searching_and_sorting;

import java.util.HashMap;
import java.util.Map;

public class CountPairWithSum {
    public static void main(String[] args) {
        int[] a = {1, 5, 7, -1, 5};
        int sum = 6;
        findPair(a, sum);
    }

    public static void findPair(int[] a, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = a.length;
        for (int i = 0; i < n; i++) {
                map.put(a[i], map.getOrDefault(a[i], 0)+1);
        }

        int twice_count = 0;

        for (int i = 0; i < n; i++) {
            if (map.get(sum - a[i]) != null)
                twice_count += map.get(sum-a[i]);

            if (sum - a[i] == a[i])
                twice_count--;
        }
        System.out.println(" pair "+twice_count/2);
    }
}
