package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.HashMap;
import java.util.Map;

public class LargestLength0sAnd1sSubArrayUsingHashMap {
    public static void main(String[] args) {
        int[] a = {1, 0, 0, 1, 0, 1, 1};
        findMaxLength(a);
    }

    public static void findMaxLength(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++)
            a[i] = (a[i] == 0) ? -1 : 1;

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max_length = 0, ending_index = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum == 0) {
                max_length = i + 1;
                ending_index = i;
            } else if (map.containsKey(sum)) {
                if (max_length < i - map.get(sum)) {
                    max_length = i - map.get(sum);
                    ending_index = i;
                }
            } else
                map.put(sum, i);
        }

        for (int i = 0; i < n; i++)
            a[i] = (a[i] == -1 ? 0 : 1);

        int end = ending_index - max_length + 1;
        System.out.println("starting index "+end+" to "+" "+ending_index);
    }
}
