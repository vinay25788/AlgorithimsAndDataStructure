package datastructure.array.searching_and_sorting;

import java.util.HashMap;
import java.util.Map;

public class Find4ElementInArrayEqualToGivenSum {

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 1, 2};
        int x = 91;
        findPiar(a, x);
    }

    public static void findPiar(int[] a, int x) {
        Map<Integer, Pair> map = new HashMap<>();
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++)
                map.put(a[i] + a[j], new Pair(i, j));
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                int  sum = a[i] + a[j];
                if (map.containsKey(x - sum)) {
                    Pair pair = map.get(x - sum);
                    if (pair.first != i && pair.first != j && pair.second != i && pair.second != j)
                    {
                        System.out.println("first " + a[i] + " second " + a[j] + " third " + a[pair.first] + " fourth " + a[pair.second]);
                        return;
                    }
                }


            }
        }
    }
}
