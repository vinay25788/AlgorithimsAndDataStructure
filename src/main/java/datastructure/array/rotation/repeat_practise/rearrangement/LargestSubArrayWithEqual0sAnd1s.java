package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithEqual0sAnd1s {
    public static void main(String[] args) {
        int a[] = {1, 0, 0, 1, 0, 1, 1};
        findMaxLength(a);
    }

    public static void findMaxLength(int[] a) {
        Map<Integer, Integer> hm = new HashMap<>();
        int startIndex = 0, ending_index = 0;
        int n = a.length;
        for (int i = 0; i < n; i++)
            a[i] = (a[i] == 0) ? -1 : 1;

        int sum = 0;
        int max_length = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum == 0) {
                max_length = i + 1;
                ending_index = i;
            } else if (hm.containsKey(sum)) {
                if (max_length < i - hm.get(sum)) {
                    max_length = i - hm.get(sum);
                    ending_index = i;
                }
            } else
                hm.put(sum, i);
        }

        for (int i = 0; i < n; i++)
            a[i] = (a[i] == -1 ? 0 : 1);
        int end = ending_index - max_length + 1;
        System.out.println("starting end " + end + " to " + ending_index);
    }
}
